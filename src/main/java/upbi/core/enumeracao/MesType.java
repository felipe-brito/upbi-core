/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upbi.core.enumeracao;

/**
 * 
 * @author Felipe de Brito Lira <felipedebritolira@gmail.com>
 */
public enum MesType {

    JANEIRO("Janeiro"),
    FEVEREIRO("Fevereiro"),
    MARCO("Março"),
    ABRIL("Abril"),
    MAIO("Maio"),
    JUNHO("Junho"),
    JULHO("Julho"),
    AGOSTO("Agosto"),
    SETEMBRO("Setembro"),
    OUTUBRO("Outubro"),
    NOVEMBRO("Novembro"),
    DEZEMBRO("Dezembro");
    
    private final String valor;

    MesType(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return this.valor;
    }

    public static MesType getType(String valor) {
        switch (valor) {
            case "Janeiro":
                return MesType.JANEIRO;
            case "Fevereiro":
                return MesType.FEVEREIRO;
            case "Março":
                return MesType.MARCO;
            case "Abril":
                return MesType.ABRIL;
            case "Maio":
                return MesType.MAIO;
            case "Junho":
                return MesType.JUNHO;
            case "Julho":
                return MesType.JULHO;
            case "Agosto":
                return MesType.AGOSTO;
            case "Setembro":
                return MesType.SETEMBRO;
            case "Outubro":
                return MesType.OUTUBRO;
            case "Novembro":
                return MesType.NOVEMBRO;
            case "Dezembro":
                return MesType.DEZEMBRO;
            default:
                return null;
        }
    }
}
