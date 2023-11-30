import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "([#@])(?<firstWord>[A-Za-z]{3,})\\1{2}(?<secondWord>\\w{3,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> mirrorWords = new ArrayList<>();
        int pairsCount = 0;

        while (matcher.find()) {
            String firstWord = matcher.group("firstWord");
            String secondWord = matcher.group("secondWord");
            String secondWordReversed = reverseWord(secondWord);

            pairsCount++;

            if (firstWord.equals(secondWordReversed)) {
                mirrorWords.add(firstWord + " <=>" + secondWord);
            }
        }
        printResult(mirrorWords, pairsCount);
    }

    private static void printResult(List<String> mirrorWords, int pairsCount) {
        if (pairsCount == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!\n", pairsCount);
        }

        if (mirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", mirrorWords));
        }
    }

    private static String reverseWord(String secondWord) {
        return new StringBuilder(secondWord).reverse().toString();
    }
}


