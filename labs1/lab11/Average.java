package lab.systems.labs1.lab11;

import java.util.Arrays;

public class Average {
    static public double math(double[] allDots) {
        double sum = Arrays.stream(allDots).sum();
        return sum / allDots.length;
    }
}
