import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String bannedWord : bannedWords) {
            text = filterText(text, bannedWord);
        }

        printString(text);
    }

    private static void printString(String text) {
        System.out.println(text);
    }

    private static String filterText(String text, String bannedWord) {
        int index = text.indexOf(bannedWord);

        while (index != -1) {
            String replacement = repeatString("*", bannedWord.length());
            text = text.replace(bannedWord, replacement);

            index = text.indexOf(bannedWord);
        }
        return text;
    }

    private static String repeatString(String s, int length) {
        return "*".repeat(Math.max(0, length));
    }
}