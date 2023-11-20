import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items =
                Arrays.stream(scanner.nextLine()
                        .split("\\|"))
                        .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!"Yohoho!".equals(input)) {
            String[] tokens = input.split("\\s+", 2);
            String command = tokens[0];

            switch (command) {
                case "Drop" -> {
                    int index = Integer.parseInt(tokens[1]);
                    if (isIndexValid(items, index)) {
                        String removedItem = items.remove(index);
                        items.add(removedItem);
                    }
                }
                case "Loot" -> {
                    addItemsIfNotAddedToList(items, tokens[1]);
                }
                case "Steal" -> {
                    int count = Integer.parseInt(tokens[1]);
                    int startIndex = items.size() - count;

                    removeItemsFromStartIndex(items, startIndex);
                }
            }
            input = scanner.nextLine();
        }

        int sumOfItemsLength = items.stream()
                .mapToInt(String::length)
                .sum();

        double averageGain = sumOfItemsLength * 1.0 / items.size();

        printResult(items, averageGain);
    }

    private static void printResult(List<String> items, double averageGain) {
        if (items.size() == 0) {
            System.out.println("Failed treasure hunt.");
        } else {
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageGain);
        }
    }

    private static void addItemsIfNotAddedToList(List<String> items, String tokens) {
        String[] newItems = tokens.split(" ");

        for (String newItem : newItems) {
            if (!items.contains(newItem)) {
                items.add(0, newItem);
            }
        }
    }

    private static void removeItemsFromStartIndex(List<String> items, int startIndex) {
        List<String> itemsToRemove = items.subList(startIndex, items.size());
        System.out.println(String.join(", ", itemsToRemove));
        itemsToRemove.clear();
    }

    private static boolean isIndexValid(List<String> items, int index) {
        return index >= 0 && index < items.size();
    }
}




