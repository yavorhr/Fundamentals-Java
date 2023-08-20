import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputNumber = Integer.parseInt(scanner.nextLine());

        while (inputNumber % 2 != 0) {
            System.out.println("Please write an even number");
            inputNumber = Integer.parseInt(scanner.nextLine());
        }

        System.out.println("The number is: " + Math.abs(inputNumber));
    }
}