import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> plantsRarity = new LinkedHashMap<>();
        Map<String, List<Double>> plantsRating = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split("<->");
            String plant = parts[0];
            int rarity = Integer.parseInt(parts[1]);

            plantsRarity.putIfAbsent(plant, 0);
            int plantRarity = plantsRarity.get(plant);
            plantsRarity.put(plant, rarity + plantRarity);
            plantsRating.put(plant, new ArrayList<>());

        }
        String input = scanner.nextLine();
        while (!"Exhibition".equals(input)) {
            String[] tokens = input.split("\\s+");

            String command = tokens[0];
            String plant = tokens[1];

            switch (command) {
                case "Rate:":
                    if (plantsRarity.containsKey(plant) && plantsRating.containsKey(plant)) {
                        double rating = Double.parseDouble(tokens[3]);
                        if (plantsRating.containsKey(plant)) {
                            plantsRating.get(plant).add(rating);
                        }
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update:":
                    if (plantsRarity.containsKey(plant) && plantsRating.containsKey(plant)) {
                        int newRarity = Integer.parseInt(tokens[3]);
                        plantsRarity.put(plant, newRarity);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset:":
                    if (plantsRarity.containsKey(plant) && plantsRating.containsKey(plant)) {
                        plantsRating.get(plant).clear();
                    } else {
                        System.out.println("error");
                    }
                    break;
                default:
                    System.out.println("error");
            }
            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");

        plantsRarity
                .entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    int result = p2.getValue() - p1.getValue();
                    if (result == 0) {
                        if (plantsRating.get(p2.getKey()).isEmpty() || plantsRating.get(p1.getKey()).isEmpty()) {
                            return result;
                        } else {
                            double res = plantsRating.get(p2.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0.0)
                                    - plantsRating.get(p1.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
                            return (int) res;
                        }
                    } else {
                        return result;
                    }
                }).forEach(e-> System.out.println(String.format("- %s; Rarity: %d; Rating: %.2f",e.getKey(),e.getValue(),plantsRating.get(e.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0.0))));
    }
}




