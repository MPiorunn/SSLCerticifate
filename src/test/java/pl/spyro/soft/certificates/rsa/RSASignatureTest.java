package pl.spyro.soft.certificates.rsa;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RSASignatureTest {

    @Autowired
    RSAKeyPairGenerator keyPairGenerator;

    @Autowired
    RSAEncryption rsaEncryption;

    @Autowired
    RSASignatures rsaSignatures;

    @Test
    public void signatureTest() throws Exception {

        KeyPair keyPair = keyPairGenerator.generate();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        String messageToSign = "Podpisz mnie :)";

        byte[] signedMessage = rsaSignatures.sign(messageToSign.getBytes(), privateKey);

        System.out.println("Signed message " + Base64.getEncoder().encodeToString(signedMessage));

        boolean verified = rsaSignatures.verify(messageToSign.getBytes(), publicKey, signedMessage);

        Assertions.assertTrue(verified);
    }
}
