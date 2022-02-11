import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\s+");
        List<String> shopsLists = new ArrayList<>();
        shopsLists.addAll(Arrays.asList(line));

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Include":
                    String shop = tokens[1];
                    shopsLists.add(shop);
                    break;
                case "Visit":
                    String firstOrLast = tokens[1];
                    int numberOfShops = Integer.parseInt(tokens[2]);
                    if (firstOrLast.equals("first")) {
                        if (shopsLists.size() - numberOfShops >= 0) {
                            for (int j = 0; j < numberOfShops; j++) {
                                int firstIndex = 0;
                                shopsLists.remove(firstIndex);
                            }
                        }
                        break;
                    } else if (firstOrLast.equals("last")) {
                        if (shopsLists.size() - numberOfShops >= 0) {
                            for (int j = 0; j < numberOfShops; j++) {
                                int lastIndex = shopsLists.size() - 1;
                                shopsLists.remove(lastIndex);
                            }
                        }
                    }
                    break;
                case "Prefer":
                    int shopIndexOne = Integer.parseInt(tokens[1]);
                    int shopIndexTwo = Integer.parseInt(tokens[2]);
                    if (shopIndexOne >= 0 && shopIndexOne < shopsLists.size() && shopIndexTwo >= 0 && shopIndexTwo < shopsLists.size())
                        if (shopsLists.contains(shopsLists.get(shopIndexOne)) && shopsLists.contains(shopsLists.get(shopIndexTwo))) {
                            Collections.swap(shopsLists, shopIndexOne, shopIndexTwo);
                        }
                    break;
                case "Place":
                    int shopIndex = Integer.parseInt(tokens[2]);
                    int resultIndex = shopIndex + 1;
                    String shopToAdd = tokens[1];
                    if (resultIndex >= 0 && resultIndex < shopsLists.size()) {
                        shopsLists.add(resultIndex, shopToAdd);
                    }
                    break;
            }
        }

        System.out.println("Shops left:");
        System.out.println(String.join(" ", shopsLists));
    }
}





































