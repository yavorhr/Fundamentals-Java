import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final int CAL_PER_DAY_NEEDED = 2000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([\\||#])(?<item>[A-Za-z\\s]+)\\1(?<expiration>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d*)\\1";
        Pattern pattern = Pattern.compile(regex);

        String input = scanner.nextLine();

        printHowManyDaysOutput(pattern, input);
        printFoodItems(pattern, input);
    }

    private static void printHowManyDaysOutput(Pattern pattern, String input) {
        Matcher matcher = pattern.matcher(input);

        int totalCalories = getTotalCalories(matcher);
        int days = totalCalories / CAL_PER_DAY_NEEDED;

        if (totalCalories > 0) {
            System.out.printf("You have food to last you for: %d days\n", days);
        } else {
            System.out.println("No matches -> no food");
        }
    }

    private static void printFoodItems(Pattern pattern, String input) {
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String item = matcher.group("item");
            String expirationDate = matcher.group("expiration");
            String cal = matcher.group("calories");

            System.out.printf("Item: %s, Best before: %s, Nutrition: %s\n", item, expirationDate, cal);
        }
    }

    private static int getTotalCalories(Matcher matcher) {
        int totalCal = 0;
        while (matcher.find()) {
            int cal = Integer.parseInt(matcher.group("calories"));
            totalCal += cal;
        }

        return totalCal;
    }
}




