import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputText = scanner.nextLine().split("\\s+");
        List<String> words = new ArrayList<>();
        for (String s : inputText) {
            words.add(s);
        }

        String input = scanner.nextLine();
        while (!"Stop".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Delete":
                    int index = Integer.parseInt(tokens[1]);
                    int resultIndex = index + 1;
                    if (resultIndex >= 0 && resultIndex < words.size()) {
                        words.remove(resultIndex);
                    }
                    break;
                case "Swap":
                    String firstWord = tokens[1];
                    String secondWord = tokens[2];
                    if (words.contains(firstWord) && words.contains(secondWord)) {
                        Collections.swap(words, words.indexOf(firstWord), words.indexOf(secondWord));
                    }
                    break;
                case "Put":
                    String wordToPut = tokens[1];
                    int indexToPut = Integer.parseInt(tokens[2]);
                    int previousIndex = indexToPut - 1;
                    if (previousIndex >= 0 && previousIndex <= words.size()) {
                        words.add(previousIndex, wordToPut);
                    }
                    break;
                case "Sort":
                    Collections.sort(words);
                    Collections.reverse(words);
                    break;
                case "Replace":
                    String wordOne = tokens[1];
                    String wordTwo = tokens[2];
                    int indexOfWordTwo = words.indexOf(wordTwo);
                    if (words.contains(wordTwo)) {
                        words.remove(indexOfWordTwo);
                        words.add(indexOfWordTwo,wordOne);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(String.join(" ", words));
    }
}



































