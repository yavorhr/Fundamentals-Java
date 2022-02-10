import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String digitsRegex = "\\d";
        Pattern digitsPattern = Pattern.compile(digitsRegex);
        Matcher digitsMatcher = digitsPattern.matcher(text);

        long treshold = 1;
        while (digitsMatcher.find()) {
            int num = Integer.parseInt(digitsMatcher.group());
            treshold *= num;
        }

        String regex = "([:]{2}|[*]{2})([A-Z][a-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);

        int countEmojis = 0;
        List<String> emojis = new ArrayList<>();

        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String emoji = matcher.group();
            countEmojis++;

            int emojiSum = 0;
            for (int i = 0; i < emoji.length(); i++) {
                char currentChar = emoji.charAt(i);
                emojiSum += (int) currentChar;
            }

            if (emojiSum > treshold) {
                emojis.add(emoji);
            }
        }

        System.out.println(String.format("Cool threshold: %d", treshold));
        System.out.println(String.format("%d emojis found in the text. The cool ones are:", countEmojis));
        for (String emoji : emojis) {
            System.out.println(emoji);
        }
    }
}




