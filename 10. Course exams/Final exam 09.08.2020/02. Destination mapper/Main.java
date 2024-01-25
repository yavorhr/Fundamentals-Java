import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "(=|\\/)(?<place>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);

        List<String> destinations = new ArrayList<>();

        while (matcher.find()) {
            String place = matcher.group("place");
            destinations.add(place);
        }

        printOutput(destinations);
    }

    private static void printOutput(List<String> destinations) {
        int travelPoints = destinations.stream()
                .map(String::length)
                .mapToInt(Integer::valueOf)
                .sum();

        System.out.printf("Destinations: %s\n" +
                "Travel Points: %d\n", getDestinations(destinations), travelPoints);
    }

    private static String getDestinations(List<String> destinations) {
        return String.join(", ", destinations);
    }
}