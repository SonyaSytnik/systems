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

        //Additional task
        int ITERATIONS = 100;
        double timesRxx[] = new double[ITERATIONS];
        double timesRxy[] = new double[ITERATIONS];
        for (int i = 0; i < ITERATIONS; i++){
            Variant current = new Variant(6, i * 500, 1700);
            Generator g = new Generator(current);
            double s1[] = g.generate();
            double s2[] = g.generate();
            Corelation c = new Corelation(s1, s2);

            long startRxy = new Date().getTime();
            c.simple();
            long endRxy = new Date().getTime();

            long startRxx = new Date().getTime();
            c.auto(true);
            long endRxx = new Date().getTime();

            timesRxx[i] = endRxx - startRxx;
            timesRxy[i] = endRxy - startRxy;
        }

        String timeGraphs = Graph.convertTwo(timesRxx, timesRxy);
        System.out.println("TIME GRAPHS : ");
        System.out.println(timeGraphs);
    }
}
