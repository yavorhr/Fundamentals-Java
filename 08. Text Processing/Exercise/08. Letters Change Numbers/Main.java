import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] textAndNumb = scanner.nextLine().split("\\s+");

        double sum = 0.0;
        for (String sequance : textAndNumb) {
            char firstLetter = sequance.charAt(0);
            char lastLetter = sequance.charAt(sequance.length() - 1);
            String numberAsString = sequance.substring(1, sequance.length() - 1);
            long number = Integer.parseInt(numberAsString);
            double result = 0.0;

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

        System.out.println(String.format("%.2f", sum));
    }
}



