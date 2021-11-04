import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        boolean passIsValid = true;

        if (!checkIfLengthLegal(input)) {
            passIsValid = false;
        }
        if (
                !checkForSymbols(input)) {
            passIsValid = false;
        }
        if (
                !checkForDigits(input)) {
            passIsValid = false;
        }
        if (passIsValid) {
            System.out.println("Password is valid");
        }

    }

    private static boolean checkIfLengthLegal(String input) {
        if (input.length() >= 6 && input.length() <= 10) {

            return true;
        } else {
            System.out.println("Password must be between 6 and 10 characters");
            return false;
        }
    }

    private static boolean checkForSymbols(String input) {
        boolean isLegal = false;

        for (int i = 0; i < input.length(); i++) {
            int letter = (int) input.charAt(i);

            if (letter >= 48 && letter <= 57) {
                isLegal = true;
            } else if (letter >= 65 && letter <= 90) {
                isLegal = true;
            } else if (
                    letter >= 97 && letter <= 122) {
                isLegal = true;
            } else {
                isLegal = false;
                break;
            }

        }
        if (!isLegal) {
            System.out.println("Password must consist only of letters and digits");
            return false;
        } else {
            return true;
        }
    }

    private static boolean checkForDigits(String input) {
        int digitCounter = 0;
        for (int i = 0; i < input.length(); i++) {
            int charA = (int) input.charAt(i);
            if (charA >= 48 && charA <= 57) {
                digitCounter++;
            }
        }
        if (digitCounter < 2) {
            System.out.println("Password must have at least 2 digits");
            return false;
        } else {
            return true;
        }
    }
}