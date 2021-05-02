package lab.systems.labs2.lab22;

public class Fast {
    static double[] calculate(double[] allDots) {
        int N = allDots.length;
        double result[] = new double[N];
        double allReal[] = new double[N];
        double allImage[] = new double[N];

        for (int i = 0; i < N / 2; i++) {
            allReal[i] = Math.cos(-2 * Math.PI * i / N);
            allReal[i + N / 2] = -allReal[i];
            allImage[i] = Math.sin(-2 * Math.PI * i / N);
            allImage[i + N / 2] = -allImage[i];
        }

        for (int i = 0; i < N / 2; i++) {
            double real1 = 0;
            double real2 = 0;
            double image1 = 0;
            double image2 = 0;

            for (int j = 0; j < N / 2; j++) {
                real1 += allDots[2 * j] * allReal[2 * i * j % N];
                real2 += allDots[2 * j + 1] * allReal[2 * i * (2 * j + 1) % N];
                image1 += allDots[2 * j] * allImage[2 * i * j % N];
                image2 += allDots[2 * j + 1] * allImage[2 * i * (2 * j + 1) % N];
            }

            result[i] = Math.sqrt(Math.pow(real1 + real2, 2) + Math.pow(image1 + image2, 2));
            result[i + N / 2] = Math.sqrt(Math.pow(real1 - real2, 2) + Math.pow(image1 - image2, 2));
        }

        return result;
    }
}
