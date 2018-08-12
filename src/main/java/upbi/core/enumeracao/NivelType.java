package upbi.core.enumeracao;

import lombok.Getter;

/**
 *
 * @author Felipe
 */
public enum NivelType {
    
    BASICO("Básico"),
    INTERMEDIARIO("Intermediário"),
    TOTAL("Total");
    
    @Getter
    private final String valor;

    NivelType(String valor) {
        this.valor = valor;
    }
    
}
