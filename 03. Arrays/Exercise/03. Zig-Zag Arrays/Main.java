import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] firstArray = new String[n];
        String[] secondArray = new String[n];

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String firstElement = input[0];
            String secondElement = input[1];

            if (i % 2 == 0) {
                firstArray[i] = firstElement;
                secondArray[i] = secondElement;
            } else {
                firstArray[i] = secondElement;
                secondArray[i] = firstElement;
            }
        }

        System.out.println(String.join(" ", firstArray));
        System.out.println(String.join(" ", secondArray));
    }
}


