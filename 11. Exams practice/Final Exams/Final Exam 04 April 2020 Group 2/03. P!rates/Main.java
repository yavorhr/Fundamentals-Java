import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> mapPopulation = new LinkedHashMap<>();
        Map<String, Integer> mapGold = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"Sail".equals(input)) {
            String[] tokens = input.split("\\|\\|");
            String keyCity = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);

            mapPopulation.putIfAbsent(keyCity, 0);
            int currentPopulation = mapPopulation.get(keyCity);
            mapPopulation.put(keyCity, currentPopulation + population);

            mapGold.putIfAbsent(keyCity, 0);
            int currentGold = mapGold.get(keyCity);
            mapGold.put(keyCity, currentGold + gold);

            input = scanner.nextLine();
        }

        String line = scanner.nextLine();
        while (!"End".equals(line)) {
            String[] tokens = line.split("=>");
            String command = tokens[0];
            String town = tokens[1];

            switch (command) {
                case "Plunder":
                    int killedPeople = Integer.parseInt(tokens[2]);
                    int stolenGold = Integer.parseInt(tokens[3]);

                    if (mapPopulation.get(town) - killedPeople > 0 && mapGold.get(town) - stolenGold > 0) {
                        int newPopulation = mapPopulation.get(town) - killedPeople;
                        mapPopulation.put(town, newPopulation);

                        int newGold = mapGold.get(town) - stolenGold;
                        mapGold.put(town, newGold);

                        System.out.println(String.format("%s plundered! %d gold stolen, %d citizens killed.", town, stolenGold, killedPeople));

                    } else if (mapPopulation.get(town) - killedPeople == 0 || mapGold.get(town) - stolenGold == 0) {
                        int newPopulation = mapPopulation.get(town) - killedPeople;
                        mapPopulation.put(town, newPopulation);
                        int newGold = mapGold.get(town) + stolenGold;
                        mapGold.put(town, newGold);
                        mapGold.remove(town);
                        mapPopulation.remove(town);
                        System.out.println(String.format("%s plundered! %d gold stolen, %d citizens killed.", town, stolenGold, killedPeople));
                        System.out.println(String.format("%s has been wiped off the map!", town));
                    }

                    break;
                case "Prosper":
                    int moreGold = Integer.parseInt(tokens[2]);
                    if (moreGold > 0) {
                        int newGold = mapGold.get(town) + moreGold;
                        mapGold.put(town, newGold);
                        System.out.println(String.format("%d gold added to the city treasury. %s now has %s gold.", moreGold, town, mapGold.get(town)));
                    } else if (moreGold < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    }
                    break;

            }

            line = scanner.nextLine();
        }

        int remainingTowns = mapGold.size();

        System.out.println(String.format("Ahoy, Captain! There are %d wealthy settlements to go to:", remainingTowns));

        mapGold
                .entrySet()
                .stream()
                .sorted((t1, t2) -> {
                    int result = Integer.compare(t2.getValue(), t1.getValue());
                    if (result == 0) {
                        result = t1.getKey().compareTo(t2.getKey());
                    }
                    return result;
                }).forEach(t ->
                System.out.println(String.format("%s -> Population: %d citizens, Gold: %d kg", t.getKey(), mapPopulation.get(t.getKey()), t.getValue())));

    }
}


