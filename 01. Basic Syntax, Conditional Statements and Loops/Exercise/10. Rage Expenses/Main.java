import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = readDoubleFromConsole(scanner);
        double mousePrice = readDoubleFromConsole(scanner);
        double keyboardPrice = readDoubleFromConsole(scanner);
        double displayPrice = readDoubleFromConsole(scanner);

        int headsetTrashCount = calcTrashCount(lostGamesCount, 2);
        int mouseTrashCount = calcTrashCount(lostGamesCount, 3);
        int keyboardTrashCount = calcTrashCount(lostGamesCount, 6);
        int displayTrashCount = calcDisplayTrashCount(keyboardTrashCount);

        double headsetCost = calcItemCost(headsetPrice, headsetTrashCount);
        double mouseCost = calcItemCost(mousePrice, mouseTrashCount);
        double keyboardCost = calcItemCost(keyboardPrice, keyboardTrashCount);
        double displayCost = calcItemCost(displayPrice, displayTrashCount);
        double totalCost = headsetCost + mouseCost + keyboardCost + displayCost;

        printResult(totalCost);
    }

    private static double calcItemCost(double itemPrice, int trashesCount) {
        return itemPrice * trashesCount;
    }

    private static int calcDisplayTrashCount(int keyboardTrashCount) {
        int count = 0;

        for (int i = 1; i <= keyboardTrashCount; i++) {
            if (i % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private static int calcTrashCount(int count, int divider) {
        return count / divider;
    }

    private static void printResult(double totalCost) {
        System.out.printf("Rage expenses: %.2f lv.", totalCost);
    }

    private static double readDoubleFromConsole(Scanner scanner) {
        return Double.parseDouble(scanner.nextLine());
    }
}