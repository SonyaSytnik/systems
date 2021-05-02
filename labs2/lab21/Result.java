package lab.systems.labs2.lab21;

import lab.systems.labs1.lab11.Generator;
import lab.systems.labs1.lab11.Graph;
import lab.systems.labs1.lab11.Variant;

public class Result {
    public static void main(String[] args) {
        Variant variant = new Variant(6, 1024, 1700);

        double allDots[] = new Generator(variant).generate();
        double discreteFourier[] = Discrete.calculate(allDots);

        String graphDots = Graph.convert(allDots);
        String graphDiscreteF = Graph.convert(discreteFourier);

        System.out.println("DOTS : ");
        System.out.println(graphDots);

        System.out.println("DISCRETE FOURIER : ");
        System.out.println(graphDiscreteF);
    }
}
