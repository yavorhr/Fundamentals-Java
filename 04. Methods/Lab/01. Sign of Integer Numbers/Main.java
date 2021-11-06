import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        numberSign(num);
    }

    public static void numberSign(int number) {
        String sign = "zero";
        if (number > 0) {
            sign = "positive";
        } else if (number < 0) {
            sign = "negative";
        }

        System.out.printf("The number %d is %s.", number, sign);
    }
}









