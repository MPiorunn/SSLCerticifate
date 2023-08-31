package pl.spyro.soft.certificates.aes;

import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Component;

@Component
public class AESKeyGenerator {

    private static final String AES_ALGORITHM = "AES";
    private static final int DEFAULT_KEY_SIZE = 256;

    public SecretKey generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES_ALGORITHM);
        keyGenerator.init(DEFAULT_KEY_SIZE);
        return keyGenerator.generateKey();
    }
}
