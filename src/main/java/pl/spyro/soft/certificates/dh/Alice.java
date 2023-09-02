package pl.spyro.soft.certificates.dh;

public class Alice {

    private final int a;
    private final int P;
    private final int G;

    private int S;

    public Alice(int p, int g) {
        this.P = p;
        this.G = g;
        this.a = 4;
        System.out.println("Alice generated secret key " + a);
    }

    public int getA() {
        return (G ^ a) % P;
    }

    public void calculateS(int B) {
        this.S = (B ^ a) % P;
    }

    public int getS() {
        return this.S;
    }

}
