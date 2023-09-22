import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> deck =
                Arrays.stream(scanner.nextLine()
                        .split(":"))
                        .collect(Collectors.toList());

        List<String> newDeck = new ArrayList<>();

        String input = scanner.nextLine();
        while (!"Ready".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            String card = tokens[1];

            switch (command) {
                case "Add" -> {
                    if (deckContainsCard(card, deck)) {
                        addCardToDeck(card, newDeck);
                    } else {
                        printNotFoundMsg("Card not found");
                    }
                }
                case "Insert" -> {
                    int index = Integer.parseInt(tokens[2]);
                    if (deckContainsCard(card, deck) && indexIsValid(index, newDeck)) {
                        newDeck.add(index, card);
                    } else {
                        printNotFoundMsg("Error!");
                    }
                }
                case "Remove" -> {
                    if (deckContainsCard(card, newDeck)) {
                        newDeck.remove(card);
                    } else {
                        printNotFoundMsg("Card not found");
                    }
                }
                case "Swap" -> {
                    String secondCard = tokens[2];
                    Collections.swap(newDeck, newDeck.indexOf(card), newDeck.indexOf(secondCard));
                }
                case "Shuffle" -> Collections.reverse(newDeck);
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(" ", newDeck));
    }

    private static boolean indexIsValid(int index, List<String> newDeck) {
        return index >= 0 && index < newDeck.size();
    }

    private static void printNotFoundMsg(String message) {
        System.out.println(message);
    }

    private static boolean deckContainsCard(String card, List<String> deck) {
        if (!deck.contains(card)) {
            return false;
        }
        return true;
    }

    private static void addCardToDeck(String card, List<String> newDeck) {
        newDeck.add(card);
    }
}



