import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        String regex = "(!)(?<command>[A-z][a-z]+)\\1:\\[(?<message>\\w{8,})\\]";
        Pattern pattern = Pattern.compile(regex);

        while (n > 0) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                printMessage(matcher);
            } else {
                printErrorMessage();
            }
            n--;
        }
    }

    private static void printErrorMessage() {
        System.out.println("The message is invalid");
    }

    private static void printMessage(Matcher matcher) {
        String command = matcher.group("command");
        String message = matcher.group("message");

        StringBuilder stringBuilder = new StringBuilder(String.format("%s: ", command));
        for (char character : message.toCharArray()) {
            stringBuilder.append(String.format("%d ", +character));
        }
        System.out.println(stringBuilder);
    }
}

