import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> populationsMap = new HashMap<>();
        Map<String, Integer> goldMap = new HashMap<>();

        String input = scanner.nextLine();
        while (!"Sail".equals(input)) {
            String[] tokens = input.split("\\|\\|");
            String town = tokens[0];

            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);

            addToMap(populationsMap, town, population);
            addToMap(goldMap, town, gold);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("=>");
            String command = tokens[0];
            String town = tokens[1];

            switch (command) {
                case "Plunder" -> {
                    int people = Integer.parseInt(tokens[2]);
                    int gold = Integer.parseInt(tokens[3]);

                    boolean peopleAlive = plunderTown(populationsMap, town, people);
                    boolean moreGoldLeft = plunderTown(goldMap, town, gold);
                    deleteMapIfOtherIsDeleted(town, moreGoldLeft, peopleAlive, populationsMap, goldMap);

                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n", town, gold, people);

                    if (!moreGoldLeft || !peopleAlive) {
                        System.out.printf("%s has been wiped off the map!\n", town);
                    }
                }
                case "Prosper" -> {
                    int gold = Integer.parseInt(tokens[2]);

                    if (invalidGoldInput(gold)) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        int currentGold = goldMap.get(town);
                        int totalGold = currentGold + gold;

                        goldMap.put(town, totalGold);

                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n", gold, town, totalGold);
                    }
                }
            }

            input = scanner.nextLine();
        }
        printResult(goldMap, populationsMap);
    }

    private static void deleteMapIfOtherIsDeleted(String town, boolean moreGoldInTownLeft, boolean morePeopleInTownLeft, Map<String, Integer> populationsMap, Map<String, Integer> goldMap) {
        if (!moreGoldInTownLeft) {
            populationsMap.remove(town);
        }

        if (!morePeopleInTownLeft){
            goldMap.remove(town);
        }
    }

    private static void printResult(Map<String, Integer> goldMap, Map<String, Integer> populationsMap) {
        StringBuilder sb = new StringBuilder(String.format("Ahoy, Captain! There are %d wealthy settlements to go to:\n", goldMap.size()));

        goldMap.
                entrySet()
                .stream()
                .sorted(new ComparatorByGoldAndName())
                .forEach(entry -> {
                    sb.append(String.format("%s -> Population: %d citizens, Gold: %d kg\n",
                            entry.getKey(),
                            populationsMap.get(entry.getKey()),
                            entry.getValue()));
                });

        System.out.print(sb);
    }

    private static boolean invalidGoldInput(int gold) {
        return gold <= 0;
    }

    private static boolean plunderTown(Map<String, Integer> map, String town, int value) {
        int current = map.get(town);
        int updatedValue = current - value;

        if (updatedValue > 0) {
            map.put(town, updatedValue);
            return true;
        } else {
            map.remove(town);
            return false;
        }
    }

    private static void addToMap(Map<String, Integer> map, String city, int population) {
        map.putIfAbsent(city, 0);

        int current = map.get(city);
        int updated = current + population;

        map.put(city, updated);
    }
}




