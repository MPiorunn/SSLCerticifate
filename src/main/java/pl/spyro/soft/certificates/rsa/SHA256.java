package pl.spyro.soft.certificates.rsa;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {

    private static final String DEFAULT_HASHING_ALGORITHM = "SHA-256";

    private final MessageDigest messageDigest;

    public SHA256() throws NoSuchAlgorithmException {
        this.messageDigest = MessageDigest.getInstance(DEFAULT_HASHING_ALGORITHM);
    }

    public String hash(String input) {
        byte[] messageHash = messageDigest.digest(input.getBytes());
        return new String(messageHash);
    }

}
