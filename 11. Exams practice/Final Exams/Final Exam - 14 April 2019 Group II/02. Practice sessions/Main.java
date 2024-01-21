import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> dataRoutes = new HashMap<>();

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("->");
            String command = tokens[0];
            String currentRoad = tokens[1];

            switch (command) {
                case "Add" -> {
                    String racer = tokens[2];
                    dataRoutes.putIfAbsent(currentRoad, new ArrayList<>());
                    addRacerToRoute(dataRoutes, currentRoad, racer);
                }
                case "Move" -> {
                    String racer = tokens[2];
                    String nextRoad = tokens[3];
                    if (doesRacerExistInCurrentRoad(dataRoutes, currentRoad, racer)) {
                        moveRacerToTheNextRoad(dataRoutes, currentRoad, nextRoad, racer);
                    }
                }
                case "Close" -> dataRoutes.remove(currentRoad);
            }
            input = scanner.nextLine();
        }

        printOutput(dataRoutes);
    }

    private static void printOutput(Map<String, List<String>> dataRoutes) {
        StringBuilder sb = new StringBuilder("Practice sessions:\n");

        dataRoutes
                .entrySet()
                .stream()
                .sorted(new ComparatorByRacersCount())
                .forEach(entry -> {
                    sb.append(entry.getKey()).append(System.lineSeparator());

                    entry.getValue()
                            .forEach(racer ->
                                    sb.append(String.format("++%s\n", racer)));
                });

        System.out.println(sb);
    }

    private static void addRacerToRoute(Map<String, List<String>> dataRoutes, String currentRoad, String racer) {
        List<String> currentRacers = getRacers(dataRoutes, currentRoad);

        currentRacers.add(racer);
        dataRoutes.put(currentRoad, currentRacers);
    }

    private static void moveRacerToTheNextRoad(Map<String, List<String>> dataRoutes, String currentRoad, String nextRoad, String racer) {
        List<String> currentRacers = getRacers(dataRoutes, currentRoad);
        currentRacers.remove(racer);
        dataRoutes.put(currentRoad, currentRacers);

        addRacerToRoute(dataRoutes, nextRoad, racer);
    }

    private static List<String> getRacers(Map<String, List<String>> dataRoutes, String currentRoad) {
        return dataRoutes.get(currentRoad);
    }

    private static boolean doesRacerExistInCurrentRoad(Map<String, List<String>> dataRoutes, String currentRoad, String racer) {
        List<String> racers = getRacers(dataRoutes, currentRoad);
        return racers.contains(racer);
    }
}




