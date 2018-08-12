package upbi.core.util;

import java.time.LocalDateTime;
import upbi.core.entidades.Token;

/**
 *
 * @author Felipe de Brito Lira <felipedebritolira@gmail.com>
 * @date 03/06/2016
 *
 */
public class TokenUtil {

    public TokenUtil(){}
    
    public Boolean isValido(Token token) {
        
        return LocalDateTime.now().isAfter(token.getValidade().plusMinutes(token.getDuracaoMinutos()));
    }
    
}
