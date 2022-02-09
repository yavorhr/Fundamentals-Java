import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String regexCal = "([\\||#])(?<item>[A-Za-z\\s]+)\\1(?<expiration>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d*)\\1";
        Pattern patternCal = Pattern.compile(regexCal);
        Matcher matcherCal = patternCal.matcher(text);

        int sumCal = 0;
        while (matcherCal.find()) {
            int calories = Integer.parseInt(matcherCal.group("calories"));
            sumCal += calories;
        }

        int days = sumCal / 2000;
        System.out.println(String.format("You have food to last you for: %d days!", days));

        String regex = "([\\||#])(?<item>[A-Za-z\\s]+)\\1(?<expiration>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d*)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);


        while (matcher.find()) {
            String item = matcher.group("item");
            String expiration = matcher.group("expiration");
            int calories = Integer.parseInt(matcher.group("calories"));
            System.out.println(String.format("Item: %s, Best before: %s, Nutrition: %d", item, expiration, calories));
        }
    }
}

