import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstNameInput = readStringFromConsole(scanner);
        String secondNameInput = readStringFromConsole(scanner);
        String delimiterInput = readStringFromConsole(scanner);

        printOutput(firstNameInput, secondNameInput, delimiterInput);
    }

    private static void printOutput(String firstNameInput, String secondNameInput, String delimiterInput) {
        System.out.printf("%s%s%s", firstNameInput, delimiterInput, secondNameInput);
    }

    private static String readStringFromConsole(Scanner scanner) {
        return scanner.nextLine();
    }
}