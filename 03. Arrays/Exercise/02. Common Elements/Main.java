import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArray = scanner.nextLine().split(" ");
        String[] secondArray = scanner.nextLine().split(" ");

        for (String elementOne : secondArray) {
            for (String elementTwo : firstArray) {
                if (elementOne.equals(elementTwo)) {
                    System.out.print(elementOne + " ");
                }
            }
        }

    }
}

