/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upbi.core.enumeracao;

/**
 *
 * @author Felipe
 */
public enum NivelType {
    
    BASICO("Básico"),
    INTERMEDIARIO("Intermediário"),
    TOTAL("Total");
    
    private final String valor;

    NivelType(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return this.valor;
    }
    
}
