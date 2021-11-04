import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);

        if (firstChar < secondChar) {
            printSymbolsInRange(firstChar, secondChar);
        } else {
            printSymbolsInRange(secondChar, firstChar);
        }
    }

    private static void printSymbolsInRange(char start, char end) {

        for (char i = ++start; i < end; i++) {
            System.out.printf("%c ", i);
        }
    }
}
