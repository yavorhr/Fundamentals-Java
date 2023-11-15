import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        HashMap<Double, Integer> hashMap = new HashMap<>();

        for (double number : input) {

            hashMap.putIfAbsent(number, 1);
            addCountIfExistingKey(hashMap, number);
        }

        printResult(hashMap);
    }

    private static void addCountIfExistingKey(HashMap<Double, Integer> hashMap, double number) {
        if (hashMap.containsKey(number)) {
            int count = hashMap.get(number);
            hashMap.put(number, count + 1);
        }
    }

    private static void printResult(HashMap<Double, Integer> hashMap) {
        for (Map.Entry<Double, Integer> entrySet : hashMap.entrySet()) {
            System.out.printf("%.0f -> %d\n", entrySet.getKey(), entrySet.getValue());
        }
    }
}



