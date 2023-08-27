import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|");
        List<String> output = new ArrayList<>();

        modifyArray(input, output);
        printResult(output);
    }

    private static void modifyArray(String[] input, List<String> output) {
        for (int i = input.length - 1; i >= 0; i--) {
            String removeBlanks = input[i].replaceAll(" ", "");

            for (int j = 0; j < removeBlanks.length(); j++) {
                String numberString = removeBlanks.charAt(j) + " ";
                output.add(numberString);
            }
        }
    }

    private static void printResult(List<String> output) {
        System.out.println(output.toString().replaceAll("[\\[\\],]", ""));
    }
}


