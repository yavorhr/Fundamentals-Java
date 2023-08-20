import java.util.Scanner;

public class Main {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = START_NUMBER; i <= END_NUMBER; i++) {
            System.out.printf("%d X %d = %d%n", number, i, number * i);
        }
    }
}
