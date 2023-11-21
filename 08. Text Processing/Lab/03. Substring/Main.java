import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();
        String word = scanner.nextLine();

        int index = word.indexOf(key);

        word = manipulateString(index, word, key);

        System.out.println(word);
    }

    private static String manipulateString(int index, String word, String key) {

        while (index != -1) {
            word = word.replace(key, "");
            index = word.indexOf(key);
        }
        return word;
    }
}