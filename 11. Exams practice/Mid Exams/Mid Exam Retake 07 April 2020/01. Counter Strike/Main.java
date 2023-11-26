import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        boolean win = true;

        int frags = 0;

        while (!"End of battle".equals(input)) {
            int reach = Integer.parseInt(input);

            if (frags % 3 == 0) {
                energy += frags;
            }

            if (reach <= energy) {
                energy -= reach;
                frags++;
            } else {
                printOutput(energy, frags, "Not enough energy! Game ends with %d won battles and %d energy\n");
                win = false;
            }

            input = scanner.nextLine();
        }

        if (win){
            printOutput(energy, frags, "Won battles: %d. Energy left: %d");
        }
    }

    private static void printOutput(int energy, int frags, String s) {
        System.out.printf(s, frags, energy);
    }
}
