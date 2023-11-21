import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder others = new StringBuilder();

        addCharToCollection(input, digits, letters, others);

        printResult(digits, letters, others);
    }

    private static void printResult(StringBuilder digits, StringBuilder letters, StringBuilder others) {
        String result = String.format("%s\n%s\n%s", digits, letters, others);
        System.out.println(result);
    }

    private static void addCharToCollection(String input, StringBuilder digits, StringBuilder letters, StringBuilder others) {
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (Character.isLetter(currentChar)) {
                letters.append(currentChar);
            } else if (Character.isDigit(currentChar)) {
                digits.append(currentChar);
            } else {
                others.append(currentChar);
            }
        }
    }
}