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

            initArraysDependingOnIndex(firstArray, secondArray, i, firstElement, secondElement);
        }

        printArr(firstArray);
        printArr(secondArray);
    }

    private static void initArraysDependingOnIndex(String[] firstArray, String[] secondArray, int i, String firstElement, String secondElement) {
        if (i % 2 == 0) {
            firstArray[i] = firstElement;
            secondArray[i] = secondElement;
        } else {
            firstArray[i] = secondElement;
            secondArray[i] = firstElement;
        }
    }

    private static void printArr(String[] arr){
        System.out.println(String.join(" ",arr));
    }
}
