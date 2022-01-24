import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lineOne = scanner.nextLine().split("\\s+");
        List<Integer> playerOne = new ArrayList<>();

        String[] lineTwo = scanner.nextLine().split("\\s+");
        List<Integer> playerTwo = new ArrayList<>();

        for (String cardOne : lineOne) {
            int number = Integer.parseInt(cardOne);
            playerOne.add(number);
        }

        for (String cardTwo : lineTwo) {
            int number = Integer.parseInt(cardTwo);
            playerTwo.add(number);
        }

        while (!(playerOne.isEmpty() || playerTwo.isEmpty())) {
            if (playerOne.get(0) > playerTwo.get(0)) {
                playerOne.add(playerOne.get(0));
                playerOne.add(playerTwo.get(0));
                playerOne.remove(0);
                playerTwo.remove(0);
            } else if (playerOne.get(0) < playerTwo.get(0)) {
                playerTwo.add(playerTwo.get(0));
                playerTwo.add(playerOne.get(0));
                playerTwo.remove(0);
                playerOne.remove(0);
            } else {
                playerOne.remove(0);
                playerTwo.remove(0);
            }
        }

        if (playerOne.size() - 1 > playerTwo.size() - 1) {
            int result = 0;
            for (int playerOneCards : playerOne) {
                result += playerOneCards;
            }
            System.out.printf("First player wins! Sum: %d", result);
        } else {
            int result = 0;
            for (int playerTwoCards : playerTwo) {
                result += playerTwoCards;
            }
            System.out.printf("Second player wins! Sum: %d", result);
        }

    }
}


