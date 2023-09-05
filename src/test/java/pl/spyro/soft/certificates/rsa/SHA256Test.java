package pl.spyro.soft.certificates.rsa;

import java.util.Base64;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SHA256Test {

    SHA256 sha256 = new SHA256();

    @SuppressWarnings("StringOperationCanBeSimplified")
    @Test
    public void sameMessageSameHash() throws Exception {
        var message1 = "Hello!";
        var message2 = new String("Hello!");

        var hash1 = sha256.hash(message1);
        var hash2 = sha256.hash(message2);

        System.out.println("Hash1 : " + Base64.getEncoder().encodeToString(hash1.getBytes()));
        System.out.println("Hash2 : " + Base64.getEncoder().encodeToString(hash2.getBytes()));

        Assertions.assertEquals(message1, message2);
        Assertions.assertEquals(hash1, hash2);
    }

    @Test
    public void oneBitDifferenceDifferentHash() throws Exception {
        var message1 = "Hello!";
        var message2 = "Gello!";

        var hash1 = sha256.hash(message1);
        var hash2 = sha256.hash(message2);

        System.out.println("Hash1 : " + Base64.getEncoder().encodeToString(hash1.getBytes()));
        System.out.println("Hash2 : " + Base64.getEncoder().encodeToString(hash2.getBytes()));

        Assertions.assertNotEquals(message1, message2);
        Assertions.assertNotEquals(hash1, hash2);
    }


}
