package pl.spyro.soft.certificates.rsa;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RSAEncryptionTest {

    @Autowired
    RSAKeyPairGenerator keyPairGenerator;

    @Autowired
    RSAEncryption rsaEncryption;

    @Test
    public void RSATest() throws Exception {
        String inputText = "Ala ma kotleta";

        KeyPair keyPair = keyPairGenerator.generate();

        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        String cipherText = rsaEncryption.encrypt(inputText, publicKey);

        System.out.println("Encrypted message with RSA " + cipherText);

        String decodedCipherText = rsaEncryption.decode(cipherText, privateKey);

        Assertions.assertEquals(inputText, decodedCipherText);
    }
}
