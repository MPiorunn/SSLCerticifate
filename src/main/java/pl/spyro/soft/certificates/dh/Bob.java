package pl.spyro.soft.certificates.dh;

public class Bob {

    private final int b;
    private final int P;
    private final int G;
    private int S;

    public Bob(int P, int G) {
        this.P = P;
        this.G = G;
        this.b = 3;
        System.out.println("Bob generated secret key " + b);
    }

    public int getB() {
        return (G ^ b) % P;
    }

    public void calculateS(int A) {
        this.S = (A ^ b) % P;
    }

    public int getS() {
        return this.S;
    }

}
