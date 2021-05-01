package lab.systems.labs1.lab11;

public class Despersion {
    static public double calculate(double[] allDots) {
        double average = Average.math(allDots);
        double sum = 0;
        for (int i = 0; i < allDots.length; i++) {
            sum += (average - allDots[i]) * (average - allDots[i]);
        }
        return sum / (allDots.length - 1);
    }
}