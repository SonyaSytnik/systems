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

    static public String convertTwo(double[] dots1, double[] dots2){
        String result = "x;y1;y2\n";
        for (int i = 0; i < dots1.length; i++) {
            result += i + ";" + dots1[i] + ";" + dots2[i] + "\n";
        }
        return result;
    }
}
