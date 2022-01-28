import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] word = scanner.nextLine().split(" ");
        Map<Character, Integer> countChars = new LinkedHashMap<>();

        for (int i = 0; i < word.length; i++) {
            for (int j = 0; j < word[i].length(); j++) {
                char keySymbol = word[i].charAt(j);

                Integer count = countChars.get(keySymbol);
                if (countChars.containsKey(keySymbol)) {
                    countChars.put(keySymbol, count + 1);
                } else {
                    countChars.put(keySymbol, 1);
                }
            }
        }

        for (Map.Entry<Character, Integer> entry : countChars.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}

