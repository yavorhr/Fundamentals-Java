import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "^(.+)>(?<onlyDigits>\\d{3})\\|(?<lowerCases>[a-z]{3})\\|(?<upperCases>[A-Z]{3})\\|(?<anyExcept>[^<>]{3})<\\1$";

        Pattern pattern = Pattern.compile(regex);

        while (n-- > 0) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (!matcher.find()) {
                printResult("Try another password!");
            } else {
                String password = getPassword(matcher);
                printResult(password);
            }
        }
    }

    private static void printResult(String password) {
        System.out.println(password);
    }

    private static String getPassword(Matcher matcher) {
        StringBuilder sb = new StringBuilder("Password: ");

        String digits = matcher.group("onlyDigits");
        String lowerCases = matcher.group("lowerCases");
        String upperCases = matcher.group("upperCases");
        String symbols = matcher.group("anyExcept");

        sb.append(String.format("%s%s%s%s", digits, lowerCases, upperCases, symbols));
        return sb.toString();
    }
}




