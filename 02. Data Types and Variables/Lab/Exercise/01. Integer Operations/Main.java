import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstInt = readIntegerFromConsole(scanner);
        int secondInt = readIntegerFromConsole(scanner);
        int thirdInt = readIntegerFromConsole(scanner);
        int fourthInt = readIntegerFromConsole(scanner);

        int result = calculateFormula(firstInt, secondInt, thirdInt, fourthInt);
        System.out.println(result);
    }

    private static int calculateFormula(int firstInt, int secondInt, int thirdInt, int fourthInt) {
        return ((firstInt + secondInt) / thirdInt) * fourthInt;
    }

    private static int readIntegerFromConsole(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }
}
