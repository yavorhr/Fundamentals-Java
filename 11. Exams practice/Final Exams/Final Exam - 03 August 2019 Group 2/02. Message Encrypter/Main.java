import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^(?<separator>[$%])(?<tag>[A-Z][a-z]{2,})\\1: \\[(?<firstGroup>\\d+)\\]\\|\\[(?<secondGroup>\\d+)\\]\\|\\[(?<thirdGroup>\\d+)\\]\\|$";
        Pattern pattern = Pattern.compile(regex);

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String message = scanner.nextLine();

            Matcher matcher = pattern.matcher(message);
            printIfInputMatchesRegex(matcher);
        }
    }

    private static void printIfInputMatchesRegex(Matcher matcher) {
        if (matcher.find()) {
            String tag = matcher.group("tag");
            int firstNumber = Integer.parseInt(matcher.group("firstGroup"));
            int secondNumber = Integer.parseInt(matcher.group("secondGroup"));
            int thirdNumber = Integer.parseInt(matcher.group("thirdGroup"));
            System.out.printf("%s: %c%c%c%n",tag, firstNumber,secondNumber,thirdNumber);
        } else {
            System.out.println("Valid message not found!");
        }
    }
}

