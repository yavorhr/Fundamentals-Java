import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regexForEmojis = "([:]{2}|[*]{2})([A-Z][a-z]{2,})\\1";
        String regexForDigits = "\\d";

        long threshold = getThreshold(regexForDigits, input);
        List<String> emojis = getEmojis(input, regexForEmojis);
        printResult(threshold, emojis);

    }

    private static void printResult(long threshold, List<String> emojis) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Cool threshold: %d\n", threshold));
        sb.append(String.format("%d emojis found in the text. The cool ones are:\n", emojis.size()));
        emojis.forEach(e -> sb.append(e).append("\n"));

        System.out.println(sb);

    }

    private static List<String> getEmojis(String input, String regexForEmojis) {
        Pattern pattern = Pattern.compile(regexForEmojis);
        Matcher matcher = pattern.matcher(input);

        List<String> emojis = new ArrayList<>();

        while (matcher.find()) {
            emojis.add(matcher.group());
        }

        return emojis;
    }

    private static long getThreshold(String regexForDigits, String input) {
        Pattern pattern = Pattern.compile(regexForDigits);
        Matcher matcher = pattern.matcher(input);

        long threshold = 1;
        while (matcher.find()) {
            int num = Integer.parseInt(matcher.group());
            threshold *= num;
        }
        return threshold;
    }
}




