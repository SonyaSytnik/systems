package lab.systems.labs2.lab21;

public class Discrete {
    static double[] calculate(double[] allDots) {
        double result[] = new double[allDots.length];
        for (int i = 0; i < allDots.length; i++) {
            double real = 0;
            double image = 0;
            for (int j = 0; j < allDots.length; j++) {
                real += allDots[j] * Math.cos(-2 * Math.PI * j * i / allDots.length);
                image += allDots[j] * Math.sin(-2 * Math.PI * j * i / allDots.length);
            }
            result[i] = Math.sqrt(real * real + image * image);
        }
        return result;
    }
}