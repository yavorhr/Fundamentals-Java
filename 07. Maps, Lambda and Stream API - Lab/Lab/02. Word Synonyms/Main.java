import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> keysAndSynonyms = new TreeMap<>();
        int pairsCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < pairsCount; i++) {
            String key = scanner.nextLine();
            String synonym = scanner.nextLine();

            if (keysAndSynonyms.containsKey(key)) {
                List<String> stringList = keysAndSynonyms.get(key);
                stringList.add(synonym);
                keysAndSynonyms.put(key, stringList);
            } else {
                List<String> synonymsList = new ArrayList<>();
                synonymsList.add(synonym);
                keysAndSynonyms.put(key, synonymsList);

            }
        }
        for (Map.Entry<String, List<String>> entry : keysAndSynonyms.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), entry.getValue().toString().replaceAll("[\\]\\[]", ""));
        }
    }
}
