package pl.spyro.soft.certificates.rsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import org.springframework.stereotype.Component;

@Component
public class RSAKeyPairGenerator {

    private static final String RSA_ALGORITHM = "RSA";
    private static final int DEFAULT_KEY_LENGTH = 2048;

    private final KeyPairGenerator generator;

    public RSAKeyPairGenerator() throws NoSuchAlgorithmException {
        generator = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        generator.initialize(DEFAULT_KEY_LENGTH);
    }

    public KeyPair generate() {
        return generator.generateKeyPair();
    }

}
