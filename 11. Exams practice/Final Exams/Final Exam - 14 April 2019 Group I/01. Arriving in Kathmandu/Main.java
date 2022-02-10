import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^(?<name>[!@#$?A-Za-z\\d*]+)=(?<length>\\d*)<<(?<code>.*)$";
        Pattern pattern = Pattern.compile(regex);

        String input = scanner.nextLine();
        while (!"Last note".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find() && Integer.parseInt(matcher.group("length")) == matcher.group("code").length()) {
                String name = matcher.group("name");
                String code = matcher.group("code");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < name.length(); i++) {
                    char currentChar = name.charAt(i);
                    if (Character.isLetter(currentChar)) {
                        sb.append(currentChar);
                    }
                }
                System.out.println(String.format("Coordinates found! %s -> %s", sb.toString(), code));
            } else {
                System.out.println("Nothing found!");
            }
            input = scanner.nextLine();
        }
    }
}






