import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] textAndNumb = scanner.nextLine().split("\\s+");

        double sum = 0.0;
        for (String string : textAndNumb) {
            char firstLetter = string.charAt(0);
            char lastLetter = string.charAt(string.length() - 1);

            String numberAsString = string.substring(1, string.length() - 1);
            int number = Integer.parseInt(numberAsString);

            double result ;

            if (Character.isUpperCase(firstLetter)) {
                result = number * 1.0 / (firstLetter - 64);
            } else {
                result = number * (firstLetter - 96);
            }

            if (Character.isUpperCase(lastLetter)) {
                result -= lastLetter - 64;
            } else {
                result += lastLetter - 96;
            }

            sum += result;
        }

        printResult(sum);
    }

    private static void printResult(double sum) {
        System.out.println(String.format("%.2f", sum));
    }
}
