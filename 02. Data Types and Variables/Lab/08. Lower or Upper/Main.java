import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        printResult(input);

    }

    private static void printResult(String input) {
        if (input.equals(input.toLowerCase())){
            System.out.println("lower-case");
        } else if (input.equals(input.toUpperCase())){
            System.out.println("upper-case");
        }
    }
}