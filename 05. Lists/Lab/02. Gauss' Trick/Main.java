import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> readListOfInts = readIntArrayList(scanner);
        List<Integer> modifiedList = new ArrayList<>();

        sumFirstAndLastAndAddSumToNewArray(readListOfInts, modifiedList);
        addLastElementToNewArrayIfLengthIsOdd(readListOfInts, modifiedList);

        printArrayList(modifiedList);
    }

    private static void addLastElementToNewArrayIfLengthIsOdd(List<Integer> readListOfInts, List<Integer> modifiedList) {
        if (readListOfInts.size() % 2 != 0) {
            int middleElementIndex = readListOfInts.size() / 2;
            modifiedList.add(readListOfInts.get(middleElementIndex));
        }
    }

    private static void sumFirstAndLastAndAddSumToNewArray(List<Integer> readListOfInts, List<Integer> modifiedList) {
        for (int i = 0; i < readListOfInts.size() / 2; i++) {
            int sum = readListOfInts.get(i) + readListOfInts.get(readListOfInts.size() - 1 - i);
            modifiedList.add(sum);
        }
    }

    private static void printArrayList(List<Integer> modifiedList) {
        System.out.println(modifiedList.toString().replaceAll("[\\[\\],]","" ));
    }

    private static List<Integer> readIntArrayList(Scanner scanner) {
        List<Integer> readListOfInts =
                Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        return readListOfInts;
    }
}
