package upbi.core.enumeracao;

import lombok.Getter;

/**
 *
 * @author Felipe de Brito Lira
 */
public enum EncryptType {
    
    AES("AES"),
    MD5("MD5");
    
    @Getter
    private final String algoritmo;
    
    EncryptType(String algoritmo) {    
        this.algoritmo = algoritmo;
    }
    
}
