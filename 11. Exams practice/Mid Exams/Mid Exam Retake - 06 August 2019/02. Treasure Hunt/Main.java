import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] itemsText = scanner.nextLine().split("\\|");
        List<String> items = new ArrayList<>();
        items.addAll(Arrays.asList(itemsText));
        List<String> stolen = new ArrayList<>();

        String input = scanner.nextLine();
        while (!"Yohoho!".equals(input)) {
            String[] tokens = input.split("\\s+", 2);
            String command = tokens[0];

            switch (command) {
                case "Loot":
                    String[] loot = tokens[1].split(" ");
                    for (int i = 0; i < loot.length; i++) {
                        if (!items.contains(loot[i])) {
                            items.add(0, loot[i]);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < items.size()) {
                        items.add(items.remove(index));
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(tokens[1]);
                    while (stolen.size() < count && !items.isEmpty()) {
                        int lastIndex = items.size() - 1;
                        stolen.add(items.get(lastIndex));
                        items.remove(lastIndex);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown command");
            }
            input = scanner.nextLine();
        }

        int count = 0;
        double totalLength = 0;
        for (int i = 0; i < items.size(); i++) {
            int length = items.get(i).length();
            totalLength += length;
            count++;
        }

        Collections.reverse(stolen);
        System.out.println(String.join(", ", stolen));

        if (items.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            System.out.printf("Average treasure gain: %.2f pirate credits.%n", totalLength / count);
        }
    }
}






















