import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("@");
        int[] houses = new int[input.length];
        for (int i = 0; i < houses.length; i++) {
            houses[i] = Integer.parseInt(input[i]);
        }

        int currentIndex = 0;
        String text = scanner.nextLine();
        while (!"Love!".equals(text)) {
            String[] tokens = text.split(" ");
            int jumpLength = Integer.parseInt(tokens[1]);
            currentIndex += jumpLength;

            if (currentIndex > houses.length - 1) {
                currentIndex = 0;
            }

            if (houses[currentIndex] != 0) {
                houses[currentIndex] -= 2;
                if (houses[currentIndex] == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", currentIndex);
                }
            } else {
                System.out.printf("Place %d already had Valentine's day.%n", currentIndex);
            }
            text = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", currentIndex);

        int counter = 0;

        boolean isSuccessful = true;
        for (int house : houses) {
            if (house != 0) {
                counter++;
                isSuccessful = false;
            }
        }

        if (isSuccessful) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", counter);
        }
    }
}










