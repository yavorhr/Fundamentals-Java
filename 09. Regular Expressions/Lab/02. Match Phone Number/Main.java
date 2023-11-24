import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern regex = Pattern.compile("\\+359([ -])2\\1[\\d]{3}\\1[\\d]{4}\\b");
        Matcher matcher = regex.matcher(input);

        List<String> phoneNumbers = addPhoneNumbers(matcher);
        printResult(phoneNumbers);
    }

    private static void printResult(List<String> phoneNumbers) {
        System.out.println(String.join(", ", phoneNumbers));
    }

    private static List<String> addPhoneNumbers(Matcher matcher) {

        List<String> phoneNumbers = new ArrayList<>();

        while (matcher.find()) {
            phoneNumbers.add(matcher.group());
        }
        return phoneNumbers;
    }
}
