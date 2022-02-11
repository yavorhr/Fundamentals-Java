import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("!");
        List<String> shoppingList = new ArrayList<>();
        shoppingList.addAll(Arrays.asList(text));

        String input = scanner.nextLine();
        while (!"Go Shopping!".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String item = tokens[1];
            switch (command) {
                case "Urgent":
                    if (!shoppingList.contains(item)) {
                        shoppingList.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    if (shoppingList.contains(item)) {
                        shoppingList.remove(item);
                    }
                    break;
                case "Correct":
                    String newItem = tokens[2];
                    if (shoppingList.contains(item)) {
                        shoppingList.set(shoppingList.indexOf(item), newItem);
                    }
                    break;
                case "Rearrange":
                    if (shoppingList.contains(item)) {
                        shoppingList.remove(item);
                        shoppingList.add(item);
                        break;
                    }
            }
            input = scanner.nextLine();

        }
        System.out.println(String.join(", ", shoppingList));
    }
}








