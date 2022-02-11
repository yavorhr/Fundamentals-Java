import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] deckCardsText = scanner.nextLine().split(":");
        List<String> deckCards = new ArrayList<>();
        deckCards.addAll(Arrays.asList(deckCardsText));
        List<String> newDeck = new ArrayList<>();

        String input = scanner.nextLine();
        while (!"Ready".equals(input)) {

            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String cardName = tokens[1];

            switch (command) {
                case "Add":
                    if (deckCards.contains(cardName)) {
                        newDeck.add(cardName);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if (deckCards.contains(cardName) && index >= 0 && index < newDeck.size()) {
                        newDeck.add(index, cardName);
                    } else {
                        System.out.println("Error!");
                    }
                    break;
                case "Remove":
                    if (newDeck.contains(cardName)) {
                        newDeck.remove(cardName);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Swap":
                    String otherCard = tokens[2];
                    Collections.swap(newDeck, newDeck.indexOf(cardName), newDeck.indexOf(otherCard));
                    break;
                default:
                    Collections.reverse(newDeck);
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(" ", newDeck));
    }
}




















