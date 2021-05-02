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
    }
}
