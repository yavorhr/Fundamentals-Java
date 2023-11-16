import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, List<String>> registry = new HashMap<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" -> ");
            String company = tokens[0];
            String id = tokens[1];

            registry.putIfAbsent(company, new ArrayList<>());
            addIdToRegistry(registry, company, id);

            input = scanner.nextLine();
        }
        printRegistry(registry);
    }

    private static void printRegistry(HashMap<String, List<String>> registry) {
        registry
                .entrySet()
                .stream()
                .sorted((c1, c2) -> c1.getKey().compareTo(c2.getKey()))
                .forEach(entry -> {
                    System.out.println(entry.getKey());

                    entry.getValue().forEach(id -> System.out.println("-- " + id));
                });
    }

    private static void addIdToRegistry(HashMap<String, List<String>> registry, String company, String id) {
        List<String> currentIds = registry.get(company);

        if (!currentIds.contains(id)) {
            currentIds.add(id);
        }
    }
}




