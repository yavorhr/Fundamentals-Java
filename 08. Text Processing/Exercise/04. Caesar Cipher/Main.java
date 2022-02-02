import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        cipher(text);
    }

    private static void cipher(String text) {

        StringBuilder result = new StringBuilder(text.length());

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            result.append((char)(currentChar+3));
        }
        System.out.println(result);
    }
}

