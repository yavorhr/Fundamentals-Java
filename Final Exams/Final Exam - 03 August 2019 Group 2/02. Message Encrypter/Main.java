import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "(@|\\*)(?<tag>[A-Z][a-z]{2,})\\1:\\s\\[(?<f>\\w)\\]\\|\\[(?<s>\\w)\\]\\|\\[(?<t>\\w)\\]\\|$";
        Pattern pattern = Pattern.compile(regex);

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String tag = matcher.group("tag");
                String f = matcher.group("f");
                String s = matcher.group("s");
                String t = matcher.group("t");
                System.out.println(String.format("%s: %d %d %d", tag, (int) f.charAt(0), (int) s.charAt(0), (int) t.charAt(0)));
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}







