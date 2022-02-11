import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int allBitcoins = 0;
        int bestRoom = 0;
        boolean madeIt = true;

        String[] dungeonsRooms = scanner.nextLine().split("\\|+");

        for (int i = 0; i <= dungeonsRooms.length - 1; i++) {
            String[] token = dungeonsRooms[i].split(" ");
            bestRoom++;

            String object = token[0];
            int number = Integer.parseInt(token[1]);

            if (object.equals("chest")) {
                System.out.printf("You found %d bitcoins.%n", number);
                allBitcoins = allBitcoins + number;
            } else if (object.equals("potion")) {
                int diff = 100 - health;
                if (health + number > 100) {
                    health = 100;
                    System.out.printf("You healed for %d hp.%n", diff);
                    System.out.printf("Current health: %d hp.%n", health);
                } else {
                    health += number;
                    System.out.printf("You healed for %d hp.%n", number);
                    System.out.printf("Current health: %d hp.%n", health);
                }
            } else {
                health -= number;
                if (health <= 0) {
                    System.out.printf("You died! Killed by %s.%n", object);
                    System.out.printf("Best room: %d", bestRoom);
                    madeIt = false;
                    break;
                } else {
                    System.out.printf("You slayed %s.%n", object);
                }
            }
        }
        if (madeIt) {
            System.out.println("You've made it!");
            System.out.println("Bitcoins: " + allBitcoins);
            System.out.println("Health: " + health);
        }
    }
}












