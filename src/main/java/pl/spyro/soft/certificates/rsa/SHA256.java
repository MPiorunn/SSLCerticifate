package pl.spyro.soft.certificates.rsa;

import java.security.MessageDigest;

public class SHA256 {

    private static final String DEFAULT_HASHING_ALGORITHM = "SHA-256";

    public String hash(String input) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(DEFAULT_HASHING_ALGORITHM);
        byte[] messageHash = messageDigest.digest(input.getBytes());
        return new String(messageHash);
    }
}
