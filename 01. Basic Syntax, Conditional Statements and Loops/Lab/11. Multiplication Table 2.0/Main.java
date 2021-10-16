import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());         //{theInteger} X {times} = {product}

        if (multiplier > 10) {
            System.out.printf("%d X %d = %d%n", n, multiplier, n * multiplier);
        } else {
            while (multiplier <= 10) {
                int formula = n * multiplier;

                System.out.printf("%d X %d = %d%n", n, multiplier, formula);
                multiplier++;
            }
        }

    }
}

