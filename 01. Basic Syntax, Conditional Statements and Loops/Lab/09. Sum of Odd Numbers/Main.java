import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int endIndex = Integer.parseInt(scanner.nextLine());
        int oddSum = 0;

        for (int i = 1; i <= endIndex; i++) {
            int oddNumber = i * 2 - 1;
            System.out.println(oddNumber);
            oddSum += oddNumber;
        }

        System.out.println(oddSum);
    }
}
