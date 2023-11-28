import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shops = Arrays
                .stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        int count = Integer.parseInt(scanner.nextLine());

        while (count > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            String command = tokens[0];

            switch (command) {
                case "Include" -> {
                    String newShop = tokens[1];
                    shops.add(newShop);
                }
                case "Visit" -> {
                    String direction = tokens[1];
                    int length = Integer.parseInt(tokens[2]);

                    if (shops.size() >= length) {
                        if (direction.equals("first")) {
                            removeFromFirstShop(shops, length);
                        } else if (direction.equals("last")) {
                            removeFromLastShop(shops, length);
                        }
                    }
                }

                case "Prefer" -> {
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);

                    if (indexIsValid(firstIndex, shops) && indexIsValid(secondIndex, shops)) {
                        swapIndexes(shops, firstIndex, secondIndex);
                    }
                }
                case "Place" -> {
                    String shop = tokens[1];
                    int index = Integer.parseInt(tokens[2]);

                    if (indexIsValid(index + 1, shops)) {
                        shops.add(index + 1, shop);
                    }
                }
            }
            count--;
        }
        printResult(shops);
    }

    private static void swapIndexes(List<String> shops, int firstIndex, int secondIndex) {
        Collections.swap(shops, firstIndex, secondIndex);
    }

    private static void removeFromLastShop(List<String> shops, int length) {
        for (int i = 0; i < length; i++) {
            int lastIndex = shops.size() - 1;
            shops.remove(lastIndex);
        }
    }

    private static void removeFromFirstShop(List<String> shops, int length) {
        for (int i = 0; i < length; i++) {
            int firstIndex = 0;
            shops.remove(firstIndex);
        }
    }

    private static boolean indexIsValid(int index, List<String> shops) {
        return index >= 0 && index < shops.size();
    }

    private static void printResult(List<String> shops) {
        System.out.println("Shops left: ");
        System.out.println(String.join(" ", shops));
    }
}


