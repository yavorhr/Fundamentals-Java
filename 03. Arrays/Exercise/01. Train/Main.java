import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
            System.out.print(numbers[i] + " ");
            sum += numbers[i];
        }
        System.out.println();
        System.out.println(sum);
    }
}
