import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder other = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (Character.isDigit(currentChar)) {
                digits.append(currentChar);
            } else if (Character.isAlphabetic(currentChar)) {
                letters.append(currentChar);
            } else {
                other.append(currentChar);
            }
        }

        System.out.println(digits);
        System.out.println(letters);
        System.out.println(other);
    }
}

