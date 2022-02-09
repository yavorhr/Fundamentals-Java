import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "(=|\\/)(?<place>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);

        List<String> destinations = new ArrayList<>();

        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String place = matcher.group("place");
            destinations.add(place);
        }

        int travelPoints = 0;
        for (String place : destinations) {
            travelPoints += place.length();
        }

        System.out.println(String.format("Destinations: %s", String.join(", ", destinations)));
        System.out.println(String.format("Travel Points: %d", travelPoints));

    }
}


