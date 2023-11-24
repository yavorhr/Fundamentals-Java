import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern regex = Pattern.compile("\\b(?<day>\\d{2})([\\/.-])(?<month>[A-z][a-z]{2})\\2(?<year>\\d{4})\\b");
        Matcher matcher = regex.matcher(input);

        printResult(matcher);
    }

    private static void printResult(Matcher matcher) {
        while (matcher.find()) {
            String day = matcher.group("day");
            String month = matcher.group("month");
            String year = matcher.group("year");

            System.out.printf("Day: %s, Month: %s, Year: %s%n",day,month,year);
        }
    }


}
