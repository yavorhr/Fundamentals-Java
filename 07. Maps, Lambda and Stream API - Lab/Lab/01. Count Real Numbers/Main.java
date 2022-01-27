import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" ");
        Double[] realNumbers = new Double[line.length];

        for (int i = 0; i < line.length; i++) {
            realNumbers[i] = Double.parseDouble(line[i]);
        }

        Map<Double, Integer> countRealNumbers = new TreeMap<>();

        for (Double key : realNumbers) {
            Integer getCurrentValue = countRealNumbers.get(key);
            if (!countRealNumbers.containsKey(key)) {
                countRealNumbers.put(key, 1);
            } else {
                countRealNumbers.put(key, getCurrentValue + 1);
            }
        }

        for (Map.Entry<Double, Integer> doubleIntegerEntry : countRealNumbers.entrySet()) {
            System.out.printf("%.0f -> %d%n", doubleIntegerEntry.getKey(), doubleIntegerEntry.getValue());
        }

    }
}
