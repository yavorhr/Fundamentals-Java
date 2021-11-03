import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }

        for (int i = count - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
    }
}

