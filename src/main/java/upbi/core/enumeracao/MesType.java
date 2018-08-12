package upbi.core.enumeracao;

import lombok.Getter;
import upbi.core.execoes.TypeInvalidoException;

/**
 *
 * @author Felipe de Brito Lira <felipedebritolira@gmail.com>
 */
public enum MesType {

    JANEIRO("Janeiro", "JANUARY"),
    FEVEREIRO("Fevereiro", "FEBRUARY"),
    MARCO("Março", "MARCH"),
    ABRIL("Abril", "APRIL"),
    MAIO("Maio", "MAY"),
    JUNHO("Junho", "JUNE"),
    JULHO("Julho", "JULY"),
    AGOSTO("Agosto", "AUGUST"),
    SETEMBRO("Setembro", "SEPTEMBER"),
    OUTUBRO("Outubro", "OCTOBER"),
    NOVEMBRO("Novembro", "NOVEMBER"),
    DEZEMBRO("Dezembro", "DECEMBER");

    @Getter
    private final String valor;

    @Getter
    private final String mesUS;

    MesType(String valor, String mesUS) {
        this.valor = valor;
        this.mesUS = mesUS;
    }

    public static MesType getType(String valor) throws TypeInvalidoException {
        for (MesType mesType : MesType.values()) {
            if (mesType.valor.equalsIgnoreCase(valor)) {
                return mesType;
            }
        }
        throw new TypeInvalidoException("Não existe um mês válido para o valor informado.");
    }

}
