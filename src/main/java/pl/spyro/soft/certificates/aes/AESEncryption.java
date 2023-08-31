package pl.spyro.soft.certificates.aes;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import org.springframework.stereotype.Component;

@Component
public class AESEncryption {

    private static final String DEFAULT_ALGORITHM = "AES/CBC/PKCS5Padding";

    private final Cipher AESCipher;

    public AESEncryption() throws NoSuchPaddingException, NoSuchAlgorithmException {
        AESCipher = Cipher.getInstance(DEFAULT_ALGORITHM);
    }

    public String encrypt(String input, SecretKey key, IvParameterSpec iv)
        throws InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        AESCipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] cipherText = AESCipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);
    }

    public String decrypt(String input, SecretKey key, IvParameterSpec iv)
        throws InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        AESCipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] decodedCipherText = AESCipher.doFinal(Base64.getDecoder().decode(input));
        return new String(decodedCipherText);
    }
}
