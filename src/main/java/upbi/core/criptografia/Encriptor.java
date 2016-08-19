/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upbi.core.criptografia;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.util.encoders.Hex;

/**
 *
 * @author Claudivan Moreira
 */
public class Encriptor {

    private Cipher cipher;
    private SecretKeySpec secretKeySpec;

    public String encrypt(String str) {
        String encriptedSenha = null;
        try {

            byte[] redenetKey = getKey();
            secretKeySpec = new SecretKeySpec(redenetKey, "AES");
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] resultado = cipher.doFinal(str.getBytes("UTF-8"));

            encriptedSenha = new String(Hex.encode(resultado));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException ex) {
        } catch (IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException ex) {
        }
        return encriptedSenha;
    }

    public byte[] decrypt(String str) {
        byte[] senhaPlana = null;
        try {
            byte[] keyPass = getKey();
            byte[] bufferSenha = Hex.decode(str);
            secretKeySpec = new SecretKeySpec(keyPass, "AES");
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            senhaPlana = cipher.doFinal(bufferSenha);

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException ex) {
        } catch (IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException | StringIndexOutOfBoundsException ex) {
        }
        return senhaPlana;
    }

    public boolean checkPassword(String senhaPlana, String senhaEncriptada) {
        return encrypt(senhaPlana).equals(senhaEncriptada);
    }

    private  byte[] getKey() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String redenetKey = "U(*T661fp8";
        MessageDigest md = MessageDigest.getInstance("MD5");
        return md.digest(redenetKey.getBytes("UTF-8"));
    }

    public Encriptor() {
        
    }

}
