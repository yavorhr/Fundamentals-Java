import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] banWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String banWord : banWords) {
            if (text.contains(banWord)) {
                String replacement = repeatStr("*", banWord.length());
                text = text.replace(banWord, replacement);
            }
        }
        System.out.println(text);
    }

    private static String repeatStr(String str, int length) {
        String replacement = "";
        for (int i = 0; i < length; i++) {
            replacement += str;
        }
        return replacement;
    }
}
