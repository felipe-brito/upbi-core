package upbi.core.criptografia;

import com.google.common.hash.Hashing;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import lombok.NoArgsConstructor;
import org.bouncycastle.util.encoders.Hex;
import upbi.core.enumeracao.EncryptType;
import upbi.core.execoes.EncryptorException;

/**
 * Classe responsável por realizar operações de Encriptação, Desencriptação e
 * geradção de HASH
 *
 * @author Claudivan Moreira
 */
@NoArgsConstructor
public class Encryptor {

    private final String UTF_8 = "UTF-8";

    private Cipher cipher;

    /**
     * Método que realiza a encriptação de um texto.
     *
     * @param str Texto a ser encriptado
     * @return {@link String}
     * @throws EncryptorException Lançada caso algum erro ocorra no momento da
     * encriptação
     */
    public String encrypt(String str) throws EncryptorException {

        try {

            cipher(getKey(), Cipher.ENCRYPT_MODE);
            byte[] resultado = cipher.doFinal(str.getBytes(UTF_8));

            return new String(Hex.encode(resultado));

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException ex) {
            throw new EncryptorException(String.format("Erro na encriptação do conteúdo.\nMensagem: %s", ex.getMessage()));
        }

    }

    /**
     * Método que realiza a decriptação de um texto.
     *
     * @param str Texto a ser decriptado
     * @return {@link String}
     * @throws EncryptorException Lançada caso algum erro ocorra no momento da
     * decriptação
     */
    public String decrypt(String str) throws EncryptorException {

        try {

            byte[] bufferSenha = Hex.decode(str);
            cipher(getKey(), Cipher.DECRYPT_MODE);
            return new String(cipher.doFinal(bufferSenha));

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException | StringIndexOutOfBoundsException ex) {
            throw new EncryptorException(String.format("Erro na decriptação do conteúdo.\nMensagem: %s", ex.getMessage()));
        }

    }

    /**
     * Método que realiza a checagem de uma senha. A senha plana é informada e
     * encriptada, na sequência é comparada com a senha encriptada que foi
     * informada.
     *
     * @param senhaPlana Senha plana
     * @param senhaEncriptada Senha encriptada
     * @return {@link String}
     * @throws EncryptorException Lançada caso algum erro ocorra no momento da
     * encriptação.
     */
    public boolean checkPassword(String senhaPlana, String senhaEncriptada) throws EncryptorException {
        return encrypt(senhaPlana).equals(senhaEncriptada);
    }

    /**
     * Método que realiza a geração de um código HASH, o código é baseado em
     * três chaves: uma Key recuperada do algoritmo MD5, o timestemp do servidor
     * e um UUID gerado randômicamente.
     *
     * @return {@link String}
     * @throws EncryptorException Lançada caso algum erro ocorra no momento da
     * geração do HASH.
     */
    public String hash() throws EncryptorException {

        try {

            String localDateTime = LocalDateTime.now().toString();
            String key = new String(getKey());
            String uuid = UUID.randomUUID().toString();
            return Hashing.sha256().hashString(uuid.concat(localDateTime).concat(key), StandardCharsets.UTF_8).toString();

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            throw new EncryptorException(String.format("Erro na geração do código hash.\nMensagem: %s", ex.getMessage()));
        }
    }

    /**
     * Método de recuperação de uma Key definida a parti de um algoritmo MD5
     *
     * @return Array de byte
     * @throws NoSuchAlgorithmException Lançada caso algum erro ocorra no
     * processo de geração da mensagem.
     * @throws UnsupportedEncodingException Lançada caso algum erro ocorra no
     * processo de geração da mensagem.
     */
    private byte[] getKey() throws NoSuchAlgorithmException, UnsupportedEncodingException {

        //veirifica para que a chave seja recupera da base de dados
        String redenetKey = "U(*T661fp8";
        MessageDigest md = MessageDigest.getInstance(EncryptType.MD5.getAlgoritmo());
        return md.digest(redenetKey.getBytes(UTF_8));

    }

    /**
     * Método que realiza a configuração do cipher.
     *
     * @param keyPass Chave de password
     * @param chiperMode Modo de configuração do Cipher
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    private void cipher(byte[] keyPass, int chiperMode) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {

        SecretKeySpec secretKeySpec = new SecretKeySpec(keyPass, EncryptType.AES.getAlgoritmo());
        cipher = Cipher.getInstance(EncryptType.AES.getAlgoritmo());
        cipher.init(chiperMode, secretKeySpec);
    }

}
