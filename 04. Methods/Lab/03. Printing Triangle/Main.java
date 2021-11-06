import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        printingTriangle(size);
    }

    private static void printingTriangle(int size) {
        for (int i = 1; i <= size; i++) {           //1-ви ред с 1 елемент
            printingROwsOfNumber(i);                //2-ри ред с 2 елемента
        }                                           //3-ти ред с 3 елемента
        for (int i = size - 1; i >= 1; i--) {
            printingROwsOfNumber(i);
        }
    }

    private static void printingROwsOfNumber(int lastNumber) {
        for (int i = 1; i <= lastNumber; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
