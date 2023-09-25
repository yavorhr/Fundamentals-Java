import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> ownedTanks =
                Arrays.stream(scanner.nextLine()
                        .split(", "))
                        .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(", ");
            String command = tokens[0];

            switch (command) {
                case "Add" -> {
                    String tankName = tokens[1];
                    String tank = getTank(ownedTanks, tankName);
                    if (tank.equals("")) {
                        ownedTanks.add(tankName);
                        printResult("Tank successfully bought");
                    } else {
                        printResult("Tank is already bought");
                    }
                }
                case "Remove" -> {
                    String tankName = tokens[1];
                    String tank = getTank(ownedTanks, tankName);
                    if (tank.equals("")) {
                        printResult("Tank not found");
                    } else {
                        ownedTanks.remove(tankName);
                        printResult("Tank successfully sold");
                    }
                }
                case "Remove At" -> {
                    int index = Integer.parseInt(tokens[1]);
                    if (indexIsValid(index, ownedTanks)) {
                        ownedTanks.remove(index);
                        printResult("Tank successfully sold");
                    } else {
                        printResult("Index out of range");
                    }
                }
                case "Insert" -> {
                    int index = Integer.parseInt(tokens[1]);
                    String tankInput = tokens[2];
                    String currentTank = getTank(ownedTanks, tankInput);

                    if (indexIsValid(index, ownedTanks) && currentTank.equals("")) {
                        printResult("Tank successfully bought");
                        ownedTanks.add(tankInput);
                    } else if (indexIsValid(index, ownedTanks) && !currentTank.equals("")) {
                        printResult("Tank is already bought");
                    } else {
                        printResult("Index out of range");
                    }
                }
            }
        }
        printCollection(ownedTanks);
    }

    private static void printCollection(List<String> ownedTanks) {
        System.out.println(String.join(", ", ownedTanks));
    }

    private static boolean indexIsValid(int index, List<String> ownedTanks) {
        return index >= 0 && index < ownedTanks.size();
    }

    private static void printResult(String message) {
        System.out.println(message);
    }

    private static String getTank(List<String> ownedTanks, String tankName) {
        return ownedTanks.stream()
                .filter(t -> t.equals(tankName))
                .findFirst()
                .orElse("");
    }
}




