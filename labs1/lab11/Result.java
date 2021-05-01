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
    }
}
