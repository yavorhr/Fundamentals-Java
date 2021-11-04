import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        printSmallestNbr(firstNumber, secondNumber, thirdNumber);

    }

    private static void printSmallestNbr(int a, int b, int c) {

        int smallest = a;

        if (b < a) {
            smallest = b;
        }
        if (c < b) {
            smallest = c;
        }
        System.out.println(smallest);
    }

}

