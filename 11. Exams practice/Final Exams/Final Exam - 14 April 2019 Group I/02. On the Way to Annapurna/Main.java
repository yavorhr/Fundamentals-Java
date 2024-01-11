import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> stores = new HashMap<>();

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("->");
            String command = tokens[0];
            String store = tokens[1];

            switch (command) {
                case "Add" -> {
                    String oneOrMoreItems = tokens[2];
                    stores.putIfAbsent(store, new ArrayList<>());
                    List<String> currentItems = stores.get(store);

                    currentItems.addAll(Arrays.asList(oneOrMoreItems.split(",")));
                }
                case "Remove" -> stores.remove(store);
            }
            input = scanner.nextLine();
        }

        String result = getSortedMapAsString(stores);
        System.out.println(result);
    }

    private static String getSortedMapAsString(Map<String, List<String>> stores) {
        StringBuilder printResult = new StringBuilder("Stores list:").append(System.lineSeparator());
        stores
                .entrySet()
                .stream()
                .sorted(new CustomComparator())
                .forEach(entry -> {
                    printResult
                            .append(entry.getKey())
                            .append(System.lineSeparator());
                    entry.getValue().forEach(item ->
                            printResult.append(String.format("<<%s>>\n", item)));
                });

        return printResult.toString();
    }
}

