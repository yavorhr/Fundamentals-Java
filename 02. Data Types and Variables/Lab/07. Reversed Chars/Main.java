import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = readCharFromConsole(scanner);
        char secondChar = readCharFromConsole(scanner);
        char thirdChar = readCharFromConsole(scanner);

        printReversedOutput(thirdChar, secondChar, firstChar);
    }

    private static char readCharFromConsole(Scanner scanner) {
        return scanner.nextLine().charAt(0);
    }

    private static void printReversedOutput(char firstChar, char secondChar, char thirdChar) {
        System.out.printf("%c %c %c", firstChar, secondChar, thirdChar);
    }
}