import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] itemsText = scanner.nextLine().split(", ");
        List<String> items = new ArrayList<>();
        items.addAll(Arrays.asList(itemsText));

        String input = scanner.nextLine();
        while (!"Craft!".equals(input)) {
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            String currentItem = tokens[1];

            switch (command) {
                case "Collect":
                    if (!items.contains(currentItem)) {
                        items.add(currentItem);
                    }
                    break;
                case "Drop":
                    if (items.contains(currentItem)) {
                        items.remove(currentItem);
                    }
                    break;
                case "Combine Items":
                    String[] newSplit = currentItem.split(":");
                    String oldItem = newSplit[0];
                    String newItem = newSplit[1];

                    if (items.contains(oldItem)) {
                        int index = items.indexOf(oldItem);
                        items.add(index + 1, newItem);
                    }
                    break;
                case "Renew":
                    if (items.contains(currentItem)) {
                        items.remove(currentItem);
                        items.add(currentItem);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", items));
    }
}













