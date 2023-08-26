import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstListInput = readIntArrayList(scanner);
        List<Integer> secondListInput = readIntArrayList(scanner);
        List<Integer> newList = new ArrayList<>();

        int minLength = getMinLength(firstListInput, secondListInput);

        sumListsUntilMinLength(minLength, firstListInput, secondListInput, newList);

        if (minLength != firstListInput.size()) {
            addRestNumbers(firstListInput, newList, minLength);
        } else {
            addRestNumbers(secondListInput, newList, minLength);
        }
        printNewList(newList);
    }

    private static void printNewList(List<Integer> firstAndSecondListCombined) {
        System.out.println(firstAndSecondListCombined.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void addRestNumbers(List<Integer> firstListInput, List<Integer> firstAndSecondListCombined, int minLength) {
        for (int i = minLength; i <= firstListInput.size() - 1; i++) {
            firstAndSecondListCombined.add(firstListInput.get(i));
        }
    }

    private static void sumListsUntilMinLength(int minLength, List<Integer> firstList, List<Integer> secondList, List<Integer> newList) {
        for (int i = 0; i < minLength; i++) {
            newList.add(firstList.get(i));
            newList.add(secondList.get(i));
        }
    }

    private static int getMinLength(List<Integer> firstListInput, List<Integer> secondListInput) {
        return Math.min(firstListInput.size(), secondListInput.size());
    }

    private static List<Integer> readIntArrayList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
