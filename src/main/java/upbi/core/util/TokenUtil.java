/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package upbi.core.util;

import java.util.Date;
import upbi.core.entidades.dw.Token;

/**
 *
 * @author Felipe de Brito Lira <felipedebritolira@gmail.com>
 * @date 03/06/2016
 *
 */
public class TokenUtil {

    public TokenUtil(){}
    
    public Boolean isValido(Token token) {
        return new Date().getTime() - token.getValidade().getTime() < (60 * token.getDuracaoMinutos() * 1000);
    }
    
}
