import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Plant> plants = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] tokens = splitInput(scanner.nextLine(), "<->");
            addPlantToMap(plants, tokens);
        }

        String input = scanner.nextLine();
        while (!"Exhibition".equals(input)) {
            String[] tokens = splitInput(input, ": ");
            String command = tokens[0];
            String[] innerTokens = splitInput(tokens[1], " - ");
            String name = innerTokens[0];

            Plant plant = plants.get(name);

            switch (command) {
                case "Rate" -> {
                    int rating = Integer.parseInt(innerTokens[1]);
                    plant.rate(rating);
                }
                case "Update" -> {
                    int rarity = Integer.parseInt(innerTokens[1]);
                    plant.updateRarity(rarity);
                }
                case "Reset" -> plant.resetRating();
                default -> System.out.println("error");
            }

            plants.put(name, plant);
            input = scanner.nextLine();
        }

        printOutput(plants);
    }

    private static void printOutput(Map<String, Plant> plants) {
        StringBuilder sb = new StringBuilder("Plants for the exhibition:\n");

        plants.values()
                .stream()
                .sorted()
                .forEach(p ->
                        sb.append(p).append(System.lineSeparator()));

        System.out.println(sb);
    }

    private static String[] splitInput(String input, String s) {
        return input.split(s);
    }

    private static void addPlantToMap(Map<String, Plant> plants, String[] tokens) {
        String name = tokens[0];
        int rarity = Integer.parseInt(tokens[1]);

        Plant plant = new Plant(name, rarity);
        plants.put(name, plant);
    }
}




