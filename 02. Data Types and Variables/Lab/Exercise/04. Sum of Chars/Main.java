import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = sumCharacters(n, scanner);

        System.out.printf("The sum equals: %d", sum);
    }

    private static int sumCharacters(int n, Scanner scanner) {
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int charInput = scanner.nextLine().charAt(0);
            sum += charInput;
        }
        return sum;
    }
}
