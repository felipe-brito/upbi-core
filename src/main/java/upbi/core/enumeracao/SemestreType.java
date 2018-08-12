package upbi.core.enumeracao;

import lombok.Getter;
import upbi.core.execoes.TypeInvalidoException;

/**
 *
 * @author Felipe de Brito Lira <felipedebritolira@gmail.com>
 */
public enum SemestreType {

    PRIMEIRO("Primeiro", 1),
    SEGUNDO("Segundo", 2);

    @Getter
    private final String valor;

    @Getter
    private final Integer codigo;

    SemestreType(String valor, Integer codigo) {
        this.valor = valor;
        this.codigo = codigo;
    }

    public static SemestreType getType(String valor) throws TypeInvalidoException {
        switch (valor) {
            case "Primeiro":
                return SemestreType.PRIMEIRO;
            case "Segundo":
                return SemestreType.SEGUNDO;
            default:
                throw new TypeInvalidoException("Não existe um semestre válido para o valor informado.");
        }
    }
}
