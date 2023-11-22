import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder cipheredInput = getCipherInput(input);
        printCipher(cipheredInput);
    }

    private static void printCipher(StringBuilder cipheredInput) {
        System.out.println(cipheredInput);
    }

    private static StringBuilder getCipherInput(String input) {
        StringBuilder cipheredInput = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            currentChar += 3;

            cipheredInput.append(currentChar);
        }
        return cipheredInput;
    }
}