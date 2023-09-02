package pl.spyro.soft.certificates.dh;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DiffieHellmanTest {


    @Test
    public void DiffieHellmanKeyExchange() {
        int P = 23;
        int G = 9;

        Alice alice = new Alice(P, G);
        Bob bob = new Bob(P, G);

        int A = alice.getA();

        int B = bob.getB();

        System.out.println("Alice is sending her A " + A + " to Bob");
        alice.calculateS(B);

        System.out.println("Bob is sending his B " + B + " to Alice");
        bob.calculateS(A);

        System.out.println("Alice key used for encryption/decryption : " + alice.getS());
        System.out.println("Bob key used for encryption/decryption : " + bob.getS());

        Assertions.assertEquals(alice.getS(), bob.getS());
    }
}
