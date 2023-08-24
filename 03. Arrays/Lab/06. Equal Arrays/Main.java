import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArr = readIntArray(scanner);
        int[] secondArr = readIntArray(scanner);

        boolean checkIfIdentical = Arrays.equals(firstArr, secondArr);

        if (checkIfIdentical) {
            printIdenticalOutput(firstArr);
        } else {
            printNotIdenticalOutput(firstArr, secondArr);
        }
    }

    private static void printNotIdenticalOutput(int[] firstArr, int[] secondArr) {
        for (int i = 0; i < firstArr.length; i++) {
            int firstNum = firstArr[i];
            int secondNum = secondArr[i];

            if (firstNum != secondNum) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                break;
            }
        }
    }

    private static void printIdenticalOutput(int[] firstArr) {
        int sum = Arrays.stream(firstArr).sum();
        System.out.printf("Arrays are identical. Sum: %d", sum);
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
