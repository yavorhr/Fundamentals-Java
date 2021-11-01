import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] first = scanner.nextLine().split(" ");
        String[] second = scanner.nextLine().split(" ");

        int sum = 0;
        for (int i = 0; i < first.length; i++) {
            if (!first[i].equals(second[i])) {
                System.out.printf("Arrays are not identical. Found difference at %d index.%n", i);
                return;
            }

            sum += Integer.parseInt(first[i]);
        }

        System.out.printf("Arrays are identical. Sum: %d%n", sum);
    }
}

