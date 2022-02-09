import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> plantRarities = new LinkedHashMap<>();
        Map<String, List<Double>> plantsRatings = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("<->");
            String plantName = tokens[0];
            int rarity = Integer.parseInt(tokens[1]);

            plantRarities.put(plantName, rarity);
            plantsRatings.put(plantName, new ArrayList<>());
        }
        String input = scanner.nextLine();
        while (!input.equals("Exhibition")) {
            input = input.replaceAll("-", "");
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Rate:": {
                    String plantName = tokens[1];
                    double rating = Double.parseDouble(tokens[2]);
                    if (plantsRatings.containsKey(plantName)) {
                        plantsRatings.get(plantName).add(rating);
                    }

                }
                break;
                case "Update:": {
                    String plantName = tokens[1];
                    int newRarity = Integer.parseInt(tokens[2]);
                    if (plantRarities.containsKey(plantName)) {
                        plantRarities.put(plantName, newRarity);
                    }
                }
                break;
                case "Reset:": {
                    String plantName = tokens[1];
                    plantsRatings.get(plantName).clear();
                }
                break;
                default:
                    System.out.println("error");
            }
            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");


        plantRarities
                .entrySet()
                .stream()
                .sorted((a, b) -> {
                    int result = b.getValue() - a.getValue();
                    if (result == 0) {
                        if (plantsRatings.get(b.getKey()).isEmpty() || plantsRatings.get(a.getKey()).isEmpty()){
                            return result;
                        }else{
                            double res = plantsRatings.get(b.getKey()).stream().mapToDouble(i -> i).average().orElse(0.0)
                                    - plantsRatings.get(a.getKey()).stream().mapToDouble(i -> i).average().orElse(0.0);
                            return (int) res;
                        }
                    }else{
                        return result;
                    }

                })
                .forEach(e -> {

                    System.out.println(String.format("- %s; Rarity: %d; Rating: %.2f", e.getKey(),
                            e.getValue(),plantsRatings.get(e.getKey()).stream().mapToDouble(i -> i).average().orElse(0.00)));
                });

    }
}

