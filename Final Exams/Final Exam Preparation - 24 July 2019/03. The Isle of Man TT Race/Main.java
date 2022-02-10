import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([#$%*&])(?<name>[A-Z][A-Za-z]+)\\1=(?<length>\\d*)!!(?<code>.+)$";
        Pattern pattern = Pattern.compile(regex);

        boolean found = false;

        while (!found) {
            String input = scanner.nextLine();

            Matcher matcher = pattern.matcher(input);

            if (matcher.find() && Integer.parseInt(matcher.group("length")) == matcher.group("code").length()) {
                String name = matcher.group("name");
                int length = Integer.parseInt(matcher.group("length"));
                String code = matcher.group("code");

                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < code.length(); i++) {
                    char currChar = code.charAt(i);
                    sb.append((char) (currChar + length));
                }

                System.out.println(String.format("Coordinates found! %s -> %s", name, sb.toString()));
                found = true;

            } else {
                System.out.println("Nothing found!");
            }

        }
    }
}











