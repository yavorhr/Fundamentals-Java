import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        String regex = "^([$|%])(?<tag>[A-Z][a-z]{2,})\\1:\\s\\[(?<first>\\d+)\\]\\|\\[(?<second>\\d+)\\]\\|\\[(?<third>\\d+)\\]\\|$";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < count; i++) {
            String message = scanner.nextLine();
            Matcher matcher = pattern.matcher(message);

            if (matcher.find()) {
                String result = checkForValidMessage(matcher);

                printResult(result);
            } else {
                printResult("Valid message not found!");
            }

        }
    }

    private static String checkForValidMessage(Matcher matcher) {
        String tag = matcher.group("tag");
        int firstNumber = Integer.parseInt(matcher.group("first"));
        int secondNumber = Integer.parseInt(matcher.group("second"));
        int thirdNumber = Integer.parseInt(matcher.group("third"));

        return String.format("%s: %c%c%c", tag, firstNumber,secondNumber,thirdNumber);
    }

    private static void printResult(String result) {
        System.out.println(result);
    }
}


