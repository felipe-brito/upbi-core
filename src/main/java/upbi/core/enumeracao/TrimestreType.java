package upbi.core.enumeracao;

import lombok.Getter;
import upbi.core.execoes.TypeInvalidoException;

/**
 *
 * @author Felipe de Brito Lira <felipedebritolira@gmail.com>
 */
public enum TrimestreType {

    PRIMEIRO("Primeiro", 1),
    SEGUNDO("Segundo", 2),
    TERCEIRO("Terceiro", 3),
    QUARTO("Quarto", 4);

    @Getter
    private final String valor;

    @Getter
    private final Integer codigo;

    TrimestreType(String valor, Integer codigo) {
        this.valor = valor;
        this.codigo = codigo;
    }

    public static TrimestreType getType(String valor) throws TypeInvalidoException {
        switch (valor) {
            case "Primeiro":
                return TrimestreType.PRIMEIRO;
            case "Segundo":
                return TrimestreType.SEGUNDO;
            case "Terceiro":
                return TrimestreType.TERCEIRO;
            case "Quarto":
                return TrimestreType.QUARTO;
            default:
                throw new TypeInvalidoException("Não existe um trimestre válido para o valor informado.");
        }
    }
}
