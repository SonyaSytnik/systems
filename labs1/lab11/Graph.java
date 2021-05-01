package lab.systems.labs1.lab11;

//to kontrolnaya-rabota.ru standart
public class Graph {
    static public String convert(double[] allDots) {
        String result = "x;y\n";
        for (int i = 0; i < allDots.length; i++) {
            result += i + ";" + allDots[i] + "\n";
        }
        return result;
    }
}
