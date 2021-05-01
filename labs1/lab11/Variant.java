package lab.systems.labs1.lab11;

public class Variant {
    private int n;
    private int N;
    private int W;

    public Variant(int n, int N, int W) {
        this.n = n;
        this.N = N;
        this.W = W;
    }

    public int getn() {
        return n;
    }

    public void setn(int n) {
        this.n = n;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        this.N = N;
    }

    public int getW() {
        return W;
    }

    public void setW(int w) {
        W = w;
    }
}
