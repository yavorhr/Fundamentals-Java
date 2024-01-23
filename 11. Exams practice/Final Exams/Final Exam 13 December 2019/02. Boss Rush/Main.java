import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String regex = "\\|(?<name>[A-Z]{4,})\\|:#(?<title>[A-Za-z]+\\s[A-Za-z]+)#";
        Pattern pattern = Pattern.compile(regex);

        while (n-- > 0) {
            String input = scanner.nextLine();

            Matcher matcher = pattern.matcher(input);
            if (!matcher.find()) {
                printMessage("Access denied!");
            } else {
                String bossData = getBossData(matcher);
                printMessage(bossData);
            }
        }
    }

    private static String getBossData(Matcher matcher) {
        String name = matcher.group("name");
        String title = matcher.group("title");

        return String.format("%s, %s\n>> Strength: %d\n>> Armour: %d"
                , name, title, name.length(), title.length());
    }

    private static void printMessage(String msg) {
        System.out.println(msg);
    }
}




