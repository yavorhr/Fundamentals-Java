import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words =
                Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!"Stop".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Delete" -> {
                    int index = Integer.parseInt(tokens[1]);
                    if (indexIsValid(words, index)) {
                        words.remove(index + 1);
                    }
                }
                case "Swap" -> {
                    String firstWord = tokens[1];
                    String secondWord = tokens[2];

                    if (swapIsPossible(firstWord, secondWord, words)) {
                        swapWordsByIndexes(words, firstWord, secondWord);
                    }
                }
                case "Put" -> {
                    String word = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    int desiredIndex = index - 1;

                    if (indexIsValid(words, desiredIndex)) {
                        words.add(desiredIndex, word);
                    }
                }
                case "Sort" -> {
                    Collections.sort(words);
                }
                case "Replace" -> {
                    String firstWord = tokens[1];
                    String secondWord = tokens[2];

                    if (words.contains(secondWord)) {
                        int indexSecondWord = words.indexOf(secondWord);
                        words.set(indexSecondWord, firstWord);
                    }
                }
            }
            input = scanner.nextLine();
        }
        printResult(words);
    }

    private static void printResult(List<String> words) {
        System.out.println(String.join(" ", words));
    }

    private static void swapWordsByIndexes(List<String> words, String firstWord, String secondWord) {
        int indexFirstWord = words.indexOf(firstWord);
        int indexSecondWord = words.indexOf(secondWord);

        words.set(indexFirstWord, secondWord);
        words.set(indexSecondWord, firstWord);
    }

    private static boolean indexIsValid(List<String> arrayList, int index) {
        return index >= 0 && index < arrayList.size();
    }

    private static boolean swapIsPossible(String firstWord, String secondWord, List<String> arrayList) {
        return arrayList.contains(firstWord) && arrayList.contains(secondWord);
    }
}



