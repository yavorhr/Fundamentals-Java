import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        boolean noEnergyLeft = false;

        String command = scanner.nextLine();
        while (!"End of battle".equals(command)) {
            int distance = Integer.parseInt(command);

            if (energy - distance >= 0) {
                energy = energy - distance;
                counter++;

                if (counter % 3 == 0) {
                    energy += counter;
                }

            } else {
                noEnergyLeft = true;
                break;
            }
            command = scanner.nextLine();
        }

        if (noEnergyLeft) {
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", counter, energy);
        } else {
            System.out.printf("Won battles: %d. Energy left: %d", counter, energy);
        }
    }
}







