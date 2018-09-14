package upbi.core.conversor;

import br.com.twsoftware.alfred.object.Objeto;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.text.WordUtils;
import upbi.core.execoes.GenericConvertEntityException;

/**
 * Conversor genérico de entidades
 *
 * @author Felipe Brito
 * @param <T> Tipo de entidade de origem
 * @param <E> Tipo de de entidade de destino
 */
public class GenericConvertEntity<T, E> {

    private final String GET = "get";
    private final String SET = "set";
    private final String SERIAL_VERSION_IGNORE = "serialVersionUID";

    /**
     * Classes de tipo simples
     */
    private final String[] SIMPLE = {"java.math.BigDecimal", "java.lang.Long", "java.lang.String", "java.lang.Integer", "java.time.LocalDate", "java.lang.Boolean", "java.time.LocalDateTime", "java.lang.Float", "java.util.Date"};
    private final String[] COMPLEX = {"java.util.List"};

    /**
     *
     * @param source
     * @param destination
     * @return
     * @throws GenericConvertEntityException
     */
    public E convertModel(T source, Class<E> destination) throws GenericConvertEntityException {

        try {

            Object destino = newInstance(destination);

            if (Objeto.isBlank(source)) {
                return (E) destino;
            }

            for (Field field : source.getClass().getDeclaredFields()) {

                if (!SERIAL_VERSION_IGNORE.equals(field.getName())) {

                    Object value = null;

                    if (isSimpleType(field)) {

                        value = getValue(source, field);

                    } else {

                        if (isListType(field)) {

                            Object elements = getValue(source, field);
                            List array = new ArrayList();

                            if (elements != null) {
                                iterable(elements, array);
                                value = array;
                            }

                        } else {

                            Object obj = getValue(source, field);

                            if (obj != null) {
                                value = convertModel((T) obj, (Class<E>) obj.getClass());
                            }

                        }
                    }

                    if (value != null) {
                        setValue(value, destino, field);
                    }
                }
            }

            return (E) destino;

        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException ex) {
            throw new GenericConvertEntityException(String.format("Erro ao tentar converter a entidade.\nMensagem: %s", ex.getMessage()));
        }

    }

    private void iterable(Object elements, List array) throws GenericConvertEntityException {
        for (Object obj : (List) elements) {
            Object element = convertModel((T) obj, (Class<E>) obj.getClass());
            if (Objeto.notBlank(element)) {
                array.add(element);
            }
        }
    }

    private Object newInstance(Class<E> destination) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        return Class.forName(destination.getCanonicalName()).newInstance();
    }

    private Object getValue(T source, Field field) throws SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return source.getClass().getMethod(GET.concat(WordUtils.capitalize(field.getName()))).invoke(source);
    }

    private void setValue(Object value, Object destino, Field field) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        destino.getClass().getMethod(SET.concat(WordUtils.capitalize(field.getName())), field.getType()).invoke(destino, value);
    }

    private Boolean isSimpleType(Field field) {
        return Arrays.asList(SIMPLE).contains(field.getType().toString().replace("class", "").trim());
    }

    private Boolean isListType(Field field) {
        return Arrays.asList(COMPLEX).contains(field.getType().toString().replace("interface", "").trim());
    }
}
