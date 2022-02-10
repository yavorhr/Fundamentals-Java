import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "(@|#)(?<wordOne>[A-Za-z]{3,})\\1{2}(?<wordTwo>[A-Za-z]{3,})\\1";

        //  Map<String, String> mirrorWords = new LinkedHashMap<>();

        List <String> mirrorWords = new LinkedList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        int pairCount = 0;

        while (matcher.find()) {
            String wordOne = matcher.group("wordOne");
            String wordTwo = matcher.group("wordTwo");
            pairCount++;
            StringBuilder sb = new StringBuilder(wordTwo);
            String reversed = sb.reverse().toString();

            if (wordOne.equals(reversed)) {
                count++;
                mirrorWords.add(wordOne + " <=> "+ wordTwo);
                //mirrorWords.put(wordOne, wordTwo);
            }
        }

        if (pairCount != 0) {
            System.out.println(String.format("%d word pairs found!", pairCount));
        } else {
            System.out.println("No word pairs found!");
        }

        if (!mirrorWords.isEmpty()) {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ",mirrorWords));
        } else {
            System.out.println("No mirror words!");
        }
    }
}




