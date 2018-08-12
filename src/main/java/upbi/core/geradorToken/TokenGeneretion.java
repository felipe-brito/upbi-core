package upbi.core.geradorToken;

import java.time.LocalDateTime;
import java.util.Map;
import upbi.core.criptografia.Encryptor;
import upbi.core.entidades.Token;
import upbi.core.execoes.EncryptorException;

/**
 *
 * @author Felipe de Brito Lira <felipedebritolira@gmail.com>
 * @date 03/06/2016
 *
 */
public class TokenGeneretion {

    private final Encryptor encriptor;

    public TokenGeneretion() {
        this.encriptor = new Encryptor();
    }

    public Token generator(Map<String, Object> values, Integer duracao) throws EncryptorException {

        StringBuilder builder = new StringBuilder();

        for (String str : values.keySet()) {
            builder.append(values.get(str));
        }

        duracao = duracao <= 0 ? 1 : duracao;

        return new Token(this.encriptor.encrypt(builder.toString()), LocalDateTime.now(), duracao);

    }

}
