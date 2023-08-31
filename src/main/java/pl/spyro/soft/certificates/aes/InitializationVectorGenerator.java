package pl.spyro.soft.certificates.aes;

import java.security.SecureRandom;
import javax.crypto.spec.IvParameterSpec;
import org.springframework.stereotype.Component;

@Component
public class InitializationVectorGenerator {

    private static final int DEFAULT_VECTOR_LENGTH = 16;
    private final SecureRandom random = new SecureRandom();

    public IvParameterSpec randomIV() {
        byte[] iv = new byte[DEFAULT_VECTOR_LENGTH];
        random.nextBytes(iv);
        return new IvParameterSpec(iv);
    }
}
