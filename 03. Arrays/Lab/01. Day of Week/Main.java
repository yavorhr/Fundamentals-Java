import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] daysOfWeek = {"Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday",
        };

        int n = Integer.parseInt(scanner.nextLine());
        boolean validInput = checkIfInputIsValid(n);
        printResult(validInput, n, daysOfWeek);
    }

    private static boolean checkIfInputIsValid(int n) {
        return n >= 1 && n <= 7;
    }

    private static void printResult(boolean checkInput, int n, String[] daysOfWeek) {
        if (!checkInput) {
            System.out.println("Invalid day!");
        } else {
            System.out.println(daysOfWeek[n - 1]);
        }
    }
}