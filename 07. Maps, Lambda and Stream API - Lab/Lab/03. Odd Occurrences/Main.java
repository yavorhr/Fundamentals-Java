import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        Map<String, Integer> occurrences = new LinkedHashMap<>();

        for (String word : words) {
            String wordInLowerCase = word.toLowerCase();
            if (occurrences.containsKey(wordInLowerCase)) {
                Integer count = occurrences.get(wordInLowerCase);
                occurrences.put(wordInLowerCase, count + 1);
            } else {
                occurrences.put(wordInLowerCase, 1);
            }
        }

        List<String> oddWords = new ArrayList<>();
        for (var entry : occurrences.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                oddWords.add(entry.getKey());
            }
        }

        for (int i = 0; i < oddWords.size(); i++) {
            System.out.print(oddWords.get(i));
            if (i < oddWords.size() - 1) {
                System.out.print(", ");
            }
        }

    }
}

