package lab.systems.labs1.lab11;

public class Generator {
    private Variant variant;

    public Generator(Variant variant) {
        this.variant = variant;
    }

    public double[] generate() {
        double result[] = new double[variant.getN()];
        for (int i = 0; i < variant.getN(); i++) {
            result[i] = 0;
            double A = Math.floor(Math.random() * Math.floor(12));
            double F = Math.floor(Math.random() * Math.floor(12));
            for (int j = 0; j < variant.getn(); j++) {
                double Wi = variant.getW() / variant.getn() * (j + 1);
                result[i] += A * Math.sin(Wi * j + F);
            }
        }
        return result;
    }
}
