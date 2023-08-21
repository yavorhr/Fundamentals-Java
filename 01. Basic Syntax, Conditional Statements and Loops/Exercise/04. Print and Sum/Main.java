import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int startNumber = Integer.parseInt(scanner.nextLine());
            int endNumber = Integer.parseInt(scanner.nextLine());

            int sum = sumNumbers(startNumber, endNumber);
            printResult(sum);
        } catch (NumberFormatException e){
            System.out.println("Please insert valid int input");
        }
    }

    private static int sumNumbers(int startNumber, int endNumber) {
        int sum = 0;

        for (int i = startNumber; i <= endNumber; i++) {
            System.out.print(i + " ");
            sum += i;
        }
        return sum;
    }

    private static void printResult(int sum) {
        System.out.println();
        System.out.printf("Sum: %d", sum);
    }
}