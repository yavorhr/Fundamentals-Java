import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] pirateShip = readArray(scanner);
        int[] warship = readArray(scanner);
        int maximumHealthCapacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        while (!"Retire".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Fire" -> {
                    int index = getInt(1, tokens);
                    int damage = getInt(2, tokens);

                    if (indexIsValid(warship, index)) {
                        warship[index] -= damage;

                        if (checkHealth(warship[index])) {
                            printMessage("You won! The enemy ship has sunken.");
                            return;
                        }
                    }
                }
                case "Repair" -> {
                    int index = getInt(1, tokens);
                    int health = getInt(2, tokens);

                    if (indexIsValid(pirateShip, index)) {
                        pirateShip[index] += health;

                        if (pirateShip[index] > maximumHealthCapacity) {
                            pirateShip[index] = maximumHealthCapacity;
                        }
                    }
                }
                case "Defend" -> {
                    int startIndex = getInt(1, tokens);
                    int endIndex = getInt(2, tokens);
                    int damage = getInt(3, tokens);

                    if (indexIsValid(pirateShip, startIndex) && indexIsValid(pirateShip, endIndex)) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            pirateShip[i] -= damage;

                            if (checkHealth(pirateShip[i])) {
                                printMessage("You lost! The pirate ship has sunken.");
                                return;
                            }
                        }
                    }

                }
                case "Status" -> {
                    long count = Arrays.stream(pirateShip)
                            .filter(s -> s < maximumHealthCapacity * 0.2)
                            .count();
                    System.out.printf("%d sections need repair.\n", count);
                }
            }
            input = scanner.nextLine();
        }

        if (pirateShip.length > 0 && warship.length > 0) {
            int pirateShipTotalHealth = Arrays.stream(pirateShip).sum();
            int warshipTotalHealth = Arrays.stream(warship).sum();

            String result = String.format("Pirate ship status: %d\nWarship status: %d\n", pirateShipTotalHealth, warshipTotalHealth);
            System.out.println(result);
        }
    }

    private static int getInt(int i, String[] tokens) {
        return Integer.parseInt(tokens[i]);
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(">")).mapToInt(Integer::valueOf).toArray();
    }

    private static boolean checkHealth(int health) {
        return health <= 0;
    }

    private static boolean indexIsValid(int[] warship, int index) {
        return index >= 0 && index < warship.length;
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}




