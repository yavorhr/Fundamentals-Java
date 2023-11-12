import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|");
        int health = 100;
        int bitcoins = 0;
        boolean isSuccessful = true;


        for (int i = 0; i < input.length; i++) {
            String[] tokens = input[i].split(" ");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            switch (command) {
                case "potion" -> {
                    int diff = 100 - health;
                    if (health + value > 100) {
                        printOutput(diff, "You healed for %d hp.\n");
                        health = 100;
                    } else {
                        printOutput(value, "You healed for %d hp.\n");
                        health += value;
                    }
                    printOutput(health, "Current health: %d hp.\n");
                }
                case "chest" -> {
                    bitcoins += value;
                    printOutput(value, "You found %d bitcoins.\n");
                }
                default -> {
                    if (health - value > 0) {
                        health -= value;
                        System.out.printf("You slayed %s.\n", command);
                    } else {
                        System.out.printf("You died! Killed by %s.\n", command);
                        printOutput(i + 1, "Best room: %d\n");
                        isSuccessful = false;
                    }
                }
            }
            if (!isSuccessful) {
                break;
            }
        }
        printIfIsSuccessful(health, bitcoins, isSuccessful);
    }

    private static void printOutput(int diff, String s) {
        System.out.printf(s, diff);
    }

    private static void printIfIsSuccessful(int health, int bitcoins, boolean isSuccessful) {
        if (isSuccessful) {
            System.out.println("You've made it!");
            System.out.println("Bitcoins: " + bitcoins);
            System.out.println("Health: " + health);
        }
    }
}



