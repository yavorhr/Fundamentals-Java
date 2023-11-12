import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items =
                Arrays.stream(scanner.nextLine()
                        .split(", "))
                        .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!"Craft!".equals(input)) {
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            String currentITem = tokens[1];

            switch (command) {
                case "Collect" -> {
                    if (!isItemExisting(items, currentITem)) {
                        items.add(currentITem);
                    }
                }
                case "Drop" -> {
                    items.remove(currentITem);
                }
                case "Combine Items" -> {
                    String[] inputItems = currentITem.split(": ");
                    String oldItem = inputItems[0];
                    String newItem = inputItems[1];

                    if (isItemExisting(items, oldItem)) {
                        int oldItemIndex = items.indexOf(oldItem);
                        items.add(oldItemIndex + 1, newItem);
                    }
                }
                case "Renew" -> {
                    if (isItemExisting(items, currentITem)) {
                        items.remove(currentITem);
                        items.add(currentITem);
                    }
                }
            }
            input = scanner.nextLine();
        }
        printItems(items);
    }

    private static void printItems(List<String> items) {
        System.out.println(String.join(", ", items));
    }

    private static boolean isItemExisting(List<String> items, String currentItem) {
        return items.contains(currentItem);
    }

}



