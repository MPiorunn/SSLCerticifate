package pl.spyro.soft.certificates;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.spyro.soft.certificates.aes.AESEncryption;
import pl.spyro.soft.certificates.aes.AESKeyGenerator;
import pl.spyro.soft.certificates.aes.InitializationVectorGenerator;

@SpringBootTest
class AESEncryptionTest {

    @Autowired
    AESEncryption aesEncryption;

    @Autowired
    AESKeyGenerator aesKeyGenerator;

    @Autowired
    InitializationVectorGenerator initializationVectorGenerator;


    @Test
    public void shouldEncryptMessageAndDecryptIntoTheSameText() throws Exception {
        String initialText = "Some secret message";

        SecretKey secretKey = aesKeyGenerator.generateKey();

        IvParameterSpec randomIV = initializationVectorGenerator.randomIV();

        String cipherText = aesEncryption.encrypt(initialText, secretKey, randomIV);

        System.out.println("Encrypted content with AES " + cipherText);

        String decryptedCipherText = aesEncryption.decrypt(cipherText, secretKey, randomIV);

        System.out.println("Decrypted content with AES " + decryptedCipherText);

        Assertions.assertEquals(initialText, decryptedCipherText);
    }
}
