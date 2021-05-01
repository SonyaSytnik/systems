package lab.systems.labs1.lab12;

import lab.systems.labs1.lab11.Average;

public class Corelation {
    private double[] signals1, signals2;
    private int resultLength;
    private double average1, average2;

    public Corelation(double[] signals1, double[] signals2) {
        this.signals1 = signals1;
        this.signals2 = signals2;
        this.resultLength = signals1.length / 2;
        this.average1 = Average.math(signals1);
        this.average2 = Average.math(signals2);
    }

    public double[] simple() {
        double result[] = new double[resultLength];
        double sum;

        for (int i = 0; i < resultLength; i++) {
            sum = 0;
            for (int j = 0; j < resultLength; j++) {
                sum += (signals1[i] - average1) * (signals2[i + j] - average2);
            }
            result[i] = sum / (resultLength - 1);
        }
        return result;
    }

    public double[] auto(boolean isFirstArray) {
        double result[] = new double[resultLength];
        double average = isFirstArray ? average1 : average2;
        double allDoth[] = isFirstArray ? signals1 : signals2;
        double sum;

        for (int i = 0; i < resultLength; i++) {
            sum = 0;
            for (int j = 0; j < resultLength; j++) {
                sum += (allDoth[i] - average) * (allDoth[i + j] - average);
            }
            result[i] = sum / (resultLength - 1);
        }
        return result;
    }
}
