/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upbi.core.geradorToken;

import java.util.Date;
import java.util.Map;
import upbi.core.entidades.dw.Token;
import upbi.core.criptografia.Encriptor;

/**
 *
 * @author Felipe de Brito Lira <felipedebritolira@gmail.com>
 * @date 03/06/2016
 *
 */
public class TokenGeneretion {

    private final Encriptor encriptor;

    public TokenGeneretion() {
        this.encriptor = new Encriptor();
    }

    public Token generator(Map<String, Object> values, Integer duracao) {

        StringBuilder builder = new StringBuilder();

        for (String str : values.keySet()) {
            builder.append(values.get(str));
        }

        duracao = duracao <= 0 ? 1 : duracao;
        
        return new Token(this.encriptor.encrypt(builder.toString()), new Date(), duracao);

    }

}
