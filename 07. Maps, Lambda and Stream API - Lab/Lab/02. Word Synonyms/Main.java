import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, List<String>> words = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String key = scanner.nextLine();
            String synonym = scanner.nextLine();

            words.putIfAbsent(key, new ArrayList<>());
            addSynonymToExistingKey(words, key, synonym);
        }

        printLinkedMap(words);
    }

    private static void addSynonymToExistingKey(LinkedHashMap<String, List<String>> hashMap, String key, String synonym) {
        List<String> synonymsList = hashMap.get(key);
        synonymsList.add(synonym);
        hashMap.put(key, synonymsList);
    }

    private static void printLinkedMap(LinkedHashMap<String, List<String>> hashMap) {
        for (Map.Entry<String, List<String>> entrySet : hashMap.entrySet()) {
            System.out.printf("%s - %s\n",entrySet.getKey(), String.join(", ", entrySet.getValue()) );
        }
    }
}



