import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shoppingList =
                Arrays.stream(scanner.nextLine()
                        .split("!"))
                        .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!"Go Shopping!".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            String product = tokens[1];

            switch (command) {
                case "Urgent" -> {
                    if (!isProductExisting(shoppingList, product)) {
                        shoppingList.add(0, product);
                    }
                }
                case "Unnecessary" -> {
                    shoppingList.remove(product);
                }
                case "Correct" -> {
                    String newItem = tokens[2];

                    if (isProductExisting(shoppingList, product)) {
                        int index = shoppingList.indexOf(product);
                        shoppingList.set(index, newItem);
                    }

                }
                case "Rearrange" -> {
                    if (isProductExisting(shoppingList, product)) {
                        shoppingList.remove(product);
                        shoppingList.add(product);
                    }
                }
            }
            input = scanner.nextLine();
        }
        printShoppingList(shoppingList);
    }

    private static void printShoppingList(List<String> shoppingList) {
        System.out.println(String.join(", ", shoppingList));
    }

    private static boolean isProductExisting(List<String> shoppingList, String item) {
        return shoppingList.contains(item);
    }
}



