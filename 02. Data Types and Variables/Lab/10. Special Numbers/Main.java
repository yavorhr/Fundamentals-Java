import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= count; i++) {
            int digitSum = 0;

            int currentNum = i;
            while (currentNum > 0) {
                digitSum += currentNum % 10;
                currentNum = currentNum / 10;
            }

            boolean isSpecial = (digitSum == 5) ||
                    (digitSum == 7) || (digitSum == 11);

            if (isSpecial) {
                System.out.println(i + " -> True");
            } else {
                System.out.println(i + " -> False");
            }
        }

    }
}
