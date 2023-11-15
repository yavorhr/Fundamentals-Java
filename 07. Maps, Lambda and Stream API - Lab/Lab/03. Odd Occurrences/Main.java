import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input =
                Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .map(String::toLowerCase)
                        .toArray(String[]::new);

        LinkedHashMap<String, Integer> hashMap = new LinkedHashMap<>();

        List<String> odds = new ArrayList<>();

        for (String word : input) {
            hashMap.putIfAbsent(word, 0);

            addCountIfWordExists(hashMap, word);
        }

        hashMap.forEach((key, value) -> {
            if (value % 2 != 0) {
                odds.add(key);
            }
        });

        printResult(odds);
    }

    private static void printResult(List<String> odds) {
        System.out.println(String.join(", ", odds));
    }

    private static void addCountIfWordExists(LinkedHashMap<String, Integer> hashMap, String word) {
        int count = hashMap.get(word);
        count += 1;

        hashMap.put(word, count);
    }
}


