import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        HashMap<Character, Integer> occurrencesMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char letter = words[i].charAt(j);

                occurrencesMap.putIfAbsent(letter, 0);

                addCountToExistingLetter(occurrencesMap, letter);
            }
        }
        printResult(occurrencesMap);
    }

    private static void printResult(HashMap<Character, Integer> occurrencesMap) {
        for (Map.Entry<Character, Integer> entrySet : occurrencesMap.entrySet()) {
            System.out.printf("%c -> %d\n", entrySet.getKey(),entrySet.getValue());
        }
    }

    private static void addCountToExistingLetter(HashMap<Character, Integer> occurrencesMap, char letter) {
        int count = occurrencesMap.get(letter);
        count += 1;

        occurrencesMap.put(letter, count);
    }
}


