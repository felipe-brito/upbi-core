/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upbi.core.enumeracao;

/**
 * 
 * @author Felipe de Brito Lira <felipedebritolira@gmail.com>
 */
public enum SemestreType {

    PRIMEIRO("Primeiro"),
    SEGUNDO("Segundo");
    
    private final String valor;

    SemestreType(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return this.valor;
    }

    public static SemestreType getType(String valor) {
        switch (valor) {
            case "Primeiro":
                return SemestreType.PRIMEIRO;
            case "Segundo":
                return SemestreType.SEGUNDO;
            default:
                return null;
        }
    }
}
