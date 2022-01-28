import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!"stop".equals(input)) {
            String key = input;
            int quantity = Integer.parseInt(scanner.nextLine());

            if (resources.containsKey(key)) {
                Integer currentValue = resources.get(key);
                resources.put(key, currentValue + quantity);
            } else {
                resources.put(key, quantity);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}

