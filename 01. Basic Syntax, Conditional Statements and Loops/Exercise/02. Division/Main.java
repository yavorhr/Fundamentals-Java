import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int inputNumber = Integer.parseInt(scanner.nextLine());
            printResult(inputNumber);
        } catch (NumberFormatException e){
            System.out.println("Not valid input. Please enter integer number");
        }
    }

    private static void printResult(int inputNumber) {
        String output = "";

        if (inputNumber % 10 == 0) {
            output = "The number is divisible by 10";
        } else if (inputNumber % 7 == 0) {
            output = "The number is divisible by 7";
        } else if (inputNumber % 6 == 0) {
            output = "The number is divisible by 6";
        } else if (inputNumber % 3 == 0) {
            output = "The number is divisible by 3";
        } else if (inputNumber % 2 == 0) {
            output = "The number is divisible by 2";
        } else {
            output = "Not divisible";
        }

        System.out.println(output);
    }
}