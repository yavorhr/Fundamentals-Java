import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int times = Integer.parseInt(scanner.nextLine());

        printResult(number, times);
    }

    private static void printResult(int number, int times) {
        if (times > 10) {
            printLine(number, times);
        } else {
            for (int i = times; i <= 10; i++) {
                printLine(times, i);
            }
        }
    }

    private static void printLine(int number, int times) {
        System.out.printf("%d x %d = %d%n", number, times, number * times);
    }
}
