import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int oddSum = 0;

        for (int i = 1; i <= n; i++) {
            int oddN = i * 2 - 1;
            System.out.println(oddN);
            oddSum += oddN;
        }

        System.out.println("Sum:" + " " + oddSum);
    }
}
