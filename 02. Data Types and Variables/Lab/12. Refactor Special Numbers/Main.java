import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        boolean isSpecial = false;

        for (int i = 1; i <= count; i++) {
            int digitSum = 0;

            int currentNum = i;
            while (currentNum > 0) {
                digitSum += currentNum % 10;
                currentNum /= 10;
            }

            isSpecial = (digitSum == 5) || (digitSum == 7) || (digitSum == 11);

            if (isSpecial) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }
        }

    }
}
