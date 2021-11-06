import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double numberOne = Double.parseDouble(scanner.nextLine());
        String operator = scanner.nextLine();
        double numberTwo = Double.parseDouble(scanner.nextLine());

        System.out.printf("%.0f", mathOperations(numberOne, operator, numberTwo));
    }

    private static double mathOperations(double firstNumber, String operator, double secondNumber) {
        double result = 0;

        switch (operator) {
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
        }
        return result;
    }

}
