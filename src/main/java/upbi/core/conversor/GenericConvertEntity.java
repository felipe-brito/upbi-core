package upbi.core.conversor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.text.WordUtils;
import upbi.core.execoes.GenericConvertEntityException;

/**
 * Conversor genérico de entidades
 *
 * @author Felipe Brito
 * @param <T> Tipo de entidade de origem
 * @param <E> Tipode de entidade de destino
 */
public class GenericConvertEntity<T, E> {

    private final String GET = "get";
    private final String SET = "set";
    private final String SERIAL_VERSION_IGNORE = "serialVersionUID";

    /**
     *
     * @param source
     * @param destination
     * @return
     * @throws GenericConvertEntityException
     */
    public E convertModel(T source, Class<E> destination) throws GenericConvertEntityException {

        //acressentar validação para tipo complexo
        //adicionar converrsão para List
        try {

            Object destino = newInstance(destination);

            if (source == null) {
                return (E) destino;
            }

            for (Field field : source.getClass().getDeclaredFields()) {
                if (!SERIAL_VERSION_IGNORE.equals(field.getName())) {
                    Object value = getValue(source, field);
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

    private Object newInstance(Class<E> destination) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        return Class.forName(destination.getCanonicalName()).newInstance();
    }

    private Object getValue(T source, Field field) throws SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return source.getClass().getMethod(GET.concat(WordUtils.capitalize(field.getName()))).invoke(source);
    }

    private void setValue(Object value, Object destino, Field field) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        destino.getClass().getMethod(SET.concat(WordUtils.capitalize(field.getName())), field.getType()).invoke(destino, value);
    }
}
