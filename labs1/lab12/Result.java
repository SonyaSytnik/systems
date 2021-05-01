package lab.systems.labs1.lab12;

import lab.systems.labs1.lab11.Generator;
import lab.systems.labs1.lab11.Graph;
import lab.systems.labs1.lab11.Variant;

public class Result {
    public static void main(String[] args) {
        Variant variant = new Variant(6, 1024, 1700);

        Generator generator = new Generator(variant);
        double signals1[] = generator.generate();
        double signals2[] = generator.generate();

        Corelation corelation = new Corelation(signals1, signals2);
        double simple[] = corelation.simple();
        double auto[] = corelation.auto(true);

        String graph1 = Graph.convert(signals1);
        String graph2 = Graph.convert(signals2);
        String corelationGraph = Graph.convert(simple);
        String autoCorelationGraph = Graph.convert(auto);

        System.out.println("GRAPH 1 : ");
        System.out.println(graph1);

        System.out.println("GRAPH 2 : ");
        System.out.println(graph2);

        System.out.println("CORELATION : ");
        System.out.println(corelationGraph);

        System.out.println("AUTO CORELATION : ");
        System.out.println(autoCorelationGraph);
    }
}
