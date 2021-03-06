package upbi.core.validador;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author Felipe de Brito Lira <felipedebritolira@gmail.com>
 */
public class Validador {

    /**
     * Este método é responsavel por validar um objeto. A validação é feito nos
     * atributos dos objetos. Retorna true caso os campos definidos no objeto
     * sejam válidos, caso contrário retorna false se ao menos um campos for
     * inválido.
     *
     * @param obj
     * @return boolean - true se o objeto for válido, falso caso contrário
     */
    public Boolean validar(Object obj) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator v = factory.getValidator();
        return v.validate(obj).isEmpty();
    }
}
