/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upbi.core.enumeracao;

/**
 * 
 * @author Felipe de Brito Lira <felipedebritolira@gmail.com>
 */
public enum TrimestreType {

    PRIMEIRO("Primeiro"),
    SEGUNDO("Segundo"),
    TERCEIRO("Terceiro"),
    QUARTO("Quart");
    
    private final String valor;

    TrimestreType(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return this.valor;
    }

    public static TrimestreType getType(String valor) {
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
                return null;
        }
    }
}
