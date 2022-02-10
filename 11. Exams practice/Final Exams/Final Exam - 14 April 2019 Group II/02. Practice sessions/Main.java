import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> practiceMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("->");
            String command = tokens[0];
            switch (command) {
                case "Add":
                    String road = tokens[1];
                    String racer = tokens[2];

                    practiceMap.putIfAbsent(road, new ArrayList<>());
                    List<String> racers = practiceMap.get(road);
                    racers.add(racer);
                    practiceMap.put(road, racers);
                    break;
                case "Move":
                    String currentRoad = tokens[1];
                    String currentRacer = tokens[2];
                    String nextRoad = tokens[3];
                    if (practiceMap.get(currentRoad).contains(currentRacer)) {
                        List<String> racersCurrentRoad = practiceMap.get(currentRoad);
                        racersCurrentRoad.remove(currentRacer);
                        practiceMap.put(currentRoad, racersCurrentRoad);

                        List<String> racersNextRoad = practiceMap.get(nextRoad);
                        if (!racersNextRoad.contains(currentRacer)) {
                            racersNextRoad.add(currentRacer);
                            practiceMap.put(nextRoad, racersNextRoad);
                        }
                    }
                    break;
                case "Close":
                    String roadToRemove = tokens[1];
                    if (practiceMap.containsKey(roadToRemove)) {
                        practiceMap.remove(roadToRemove);
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.println("Practice sessions:");
        practiceMap
                .entrySet()
                .stream()
                .sorted((r1, r2) -> {
                    int result = Integer.compare(r2.getValue().size(), r1.getValue().size());
                    if (result == 0) {
                        result = r1.getKey().compareTo(r2.getKey());
                        return result;
                    }
                    return result;
                }).forEach(road -> {
            System.out.println(String.format("%s", road.getKey()));
            road.getValue().forEach(racer-> System.out.println(String.format("++%s",racer)));
        });
    }
}







