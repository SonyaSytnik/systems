package lab.systems.labs2.lab22;

import lab.systems.labs1.lab11.Generator;
import lab.systems.labs1.lab11.Graph;
import lab.systems.labs1.lab11.Variant;

public class Result {
    public static void main(String[] args) {
        Variant variant = new Variant(6, 1024, 1700);

        double allDots[] = new Generator(variant).generate();
        double fastFourier[] = Fast.calculate(allDots);

        String graphDots = Graph.convert(allDots);
        String graphFastF = Graph.convert(fastFourier);

        System.out.println("DOTS : ");
        System.out.println(graphDots);

        System.out.println("FAST FOURIER : ");
        System.out.println(graphFastF);

        //Additional task
        int ITERATIONS = 10;
        double acceleration[] = new double[ITERATIONS];
        for (int i = 1; i <= ITERATIONS; i++) {
            Variant v = new Variant(6, i * 1000, 1700);
            double dots[] = new Generator(v).generate();
            long startDFT = new Date().getTime();
            Discrete.calculate(dots);
            long entDFT = new Date().getTime();

            long startFFT = new Date().getTime();
            Fast.calculate(dots);
            long entFFT = new Date().getTime();

            acceleration[i-1] = (entDFT - startDFT) - (entFFT - startFFT);
        }
        String accelerationGraphs = Graph.convert(acceleration);
        System.out.println("acceleration GRAPHS : ");
        System.out.println(accelerationGraphs);
    }
}
