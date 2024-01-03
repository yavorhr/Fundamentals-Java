import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> guests = new HashMap<>();

        String input = scanner.nextLine();
        int unlikesCount = 0;

        while (!"Stop".equals(input)) {
            String[] tokens = input.split("-");
            String command = tokens[0];
            String name = tokens[1];
            String currentMeal = tokens[2];

            if (command.equals("Like")) {
                guests.putIfAbsent(name, new ArrayList<>());

                List<String> meals = guests.get(name);

                if (!mealExists(currentMeal, meals)) {
                    addMeal(guests, name, currentMeal, meals);
                }

            } else if (command.equals("Unlike")) {
                if (!guests.containsKey(name)) {
                    printMessage(name, " is not at the party.");
                } else {
                    List<String> meals = guests.get(name);

                    if (mealExists(currentMeal, meals)) {
                        meals.removeIf(m -> m.equals(currentMeal));
                        printMessage(name, " doesn't like the shrimps.");
                        unlikesCount++;

                        guests.put(name, meals);
                    } else {
                        printMessage(name, " doesn't have the salad in his/her collection.");
                    }
                }
            }
            input = scanner.nextLine();
        }
        printResult(guests, unlikesCount);
    }

    private static void addMeal(Map<String, List<String>> guests, String name, String currentMeal, List<String> meals) {
        meals.add(currentMeal);
        guests.put(name, meals);
    }

    private static boolean mealExists(String currentMeal, List<String> meals) {
        return meals.contains(currentMeal);
    }

    private static void printResult(Map<String, List<String>> guests, int unlikesCount) {
        guests.entrySet().stream().sorted((g1, g2) -> {
            int result = g2.getValue().size() - g1.getValue().size();
            if (result == 0) {
                result = g1.getKey().compareTo(g2.getKey());
            }
            return result;
        }).forEach(g -> System.out.printf("%s: %s\n", g.getKey(), getMeals(g.getValue())));

        System.out.printf("Unliked meals: %d", unlikesCount);
    }

    private static String getMeals(List<String> list) {
        return String.join(", ", list);
    }

    private static void printMessage(String name, String message) {
        System.out.println(name + message);
    }
}

