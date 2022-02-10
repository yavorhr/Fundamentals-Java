import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^([$|%])(?<tag>[A-Z][a-z]{2,})\\1:\\s\\[(?<f>\\d+)\\]\\|\\[(?<s>\\d+)\\]\\|\\[(?<t>\\d+)\\]\\|$";
        Pattern pattern = Pattern.compile(regex);

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String tag = matcher.group("tag");
                int f = Integer.parseInt(matcher.group("f"));
                int s = Integer.parseInt(matcher.group("s"));
                int t = Integer.parseInt(matcher.group("t"));
                System.out.println(String.format("%s: %c%c%c",tag,f,s,t ));

            } else {
                System.out.println("Valid message not found!");
            }

        }
    }
}












