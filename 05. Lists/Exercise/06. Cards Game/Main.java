import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstDeck = readIntegersFromConsole(scanner);
        List<Integer> secondDeck = readIntegersFromConsole(scanner);

        while (!(firstDeck.isEmpty() || secondDeck.isEmpty())) {
            int playerOneCard = firstDeck.get(0);
            int playerTwoCard = secondDeck.get(0);

            int result = playerOneCard - playerTwoCard;
            if (result > 0) {
                addCardsToWinningDeck(firstDeck, playerOneCard, playerTwoCard);
                removeDrawnCardsFromBothDecks(firstDeck, secondDeck);
            } else if (result < 0) {
                addCardsToWinningDeck(secondDeck, playerTwoCard, playerOneCard);
                removeDrawnCardsFromBothDecks(firstDeck, secondDeck);
            } else {
                removeDrawnCardsFromBothDecks(firstDeck, secondDeck);
            }
        }
        printWinningDeck(firstDeck, secondDeck);
    }

    private static void printWinningDeck(List<Integer> firstDeck, List<Integer> secondDeck) {
        int firstDeckSum = firstDeck.stream().mapToInt(Integer::intValue).sum();
        int secondDeckSum = secondDeck.stream().mapToInt(Integer::intValue).sum();

        if (firstDeckSum > secondDeckSum) {
            System.out.printf("First player wins! Sum: %d", firstDeckSum);
        } else {
            System.out.printf("Second player wins! Sum: %d", secondDeckSum);
        }
    }

    private static void removeDrawnCardsFromBothDecks(List<Integer> firstDeck, List<Integer> secondDeck) {
        firstDeck.remove(0);
        secondDeck.remove(0);
    }

    private static void addCardsToWinningDeck(List<Integer> firstDeck, int playerOneCard, int playerTwoCard) {
        firstDeck.add(playerOneCard);
        firstDeck.add(playerTwoCard);
    }

    private static List<Integer> readIntegersFromConsole(Scanner scanner) {
        return
                Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
    }

}


