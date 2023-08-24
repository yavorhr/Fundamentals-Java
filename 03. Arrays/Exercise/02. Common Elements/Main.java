import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArr = readArrFromConsole(scanner);
        String[] secondArr = readArrFromConsole(scanner);

        printCommonElements(firstArr, secondArr);
    }

    private static void printCommonElements(String[] firstArr, String[] secondArr) {
        List<String> firstArrAsList = Arrays.asList(firstArr);

        for (String element : secondArr) {
            if (firstArrAsList.contains(element)) {
                System.out.print(element + " ");
            }
        }
    }

    private static String[] readArrFromConsole(Scanner scanner) {
        return scanner.nextLine().split(" ");
    }
}
