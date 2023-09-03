package pl.spyro.soft.certificates.rsa;

import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import org.springframework.stereotype.Component;

@Component
public class RSASignatures {

    private static final String DEFAULT_SIGNING_ALGORITHM = "SHA256withRSA";

    private final Signature signature;

    public RSASignatures() throws NoSuchAlgorithmException {
        this.signature = Signature.getInstance(DEFAULT_SIGNING_ALGORITHM);
    }

    public byte[] sign(byte[] message, PrivateKey privateKey) throws Exception {
        signature.initSign(privateKey);
        signature.update(message);
        return signature.sign();
    }

    public boolean verify(byte[] message, PublicKey publicKey, byte[] signedMessage) throws Exception {
        signature.initVerify(publicKey);
        signature.update(message);
        return signature.verify(signedMessage);
    }
}

