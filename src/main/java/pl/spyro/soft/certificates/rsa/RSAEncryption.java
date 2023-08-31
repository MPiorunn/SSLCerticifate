package pl.spyro.soft.certificates.rsa;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.springframework.stereotype.Component;

@Component
public class RSAEncryption {

    private static final String RSA_ALGORITHM = "RSA";
    private final Cipher cipher;

    public RSAEncryption() throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.cipher = Cipher.getInstance(RSA_ALGORITHM);
    }

    public String encrypt(String input, PublicKey publicKey)
        throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        this.cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] cipherText = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);
    }

    public String decode(String cipherText, PrivateKey privateKey)
        throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        this.cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decodedCipher = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        return new String(decodedCipher);
    }
}
