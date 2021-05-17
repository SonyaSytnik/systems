package lab.systems.labs1.lab11;

public class Result {
    public static void main(String[] args) {
        Variant variant = new Variant(6, 1024, 1700);

        double allDots[] = new Generator(variant).generate();
        double average = Average.math(allDots);
        double despersion = Despersion.calculate(allDots);

        String graph = Graph.convert(allDots);

        System.out.println("AVERAGE : " + average);

        System.out.println("DESPERSION : " + despersion);

        System.out.println("GRAPH : ");
        System.out.println(graph);

        //Additional task
        int ITERATIONS = 200;
        double times[] = new double[ITERATIONS];
        for (int i = 0; i < ITERATIONS; i++){
            long start = new Date().getTime();
            Variant current = new Variant(6, i * 1000, 1700);
            new Generator(current).generate();
            long end = new Date().getTime();
            times[i] = end - start;
        }

        String timeGraph = Graph.convert(times);
        System.out.println("TIME GRAPH : ");
        System.out.println(timeGraph);
    }
}
