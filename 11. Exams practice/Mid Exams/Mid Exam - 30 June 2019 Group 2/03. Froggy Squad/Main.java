import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> frogs = Arrays.stream(scanner.nextLine()
                .split(" "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (true) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            String condition = tokens[1];

            if (command.equals("Print")) {
                switch (condition) {
                    case "Normal" -> {
                        printCollection(frogs);
                    }
                    case "Reversed" -> {
                        Collections.reverse(frogs);
                        printCollection(frogs);
                    }
                }
                break;
            }

            switch (command) {
                case "Join" -> {
                    String name = tokens[1];
                    frogs.add(name);
                }
                case "Dive" -> {
                    int index = Integer.parseInt(tokens[1]);
                    if (isIndexValid(frogs, index)) {
                        frogs.remove(index);
                    }
                }
                case "Jump" -> {
                    String name = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    if (isIndexValid(frogs, index)) {
                        frogs.add(index, name);
                    }
                }
                case "First" -> {
                    int count = Integer.parseInt(tokens[1]);
                    int rightBound = Math.min(count, frogs.size());

                    printCollectionByIndexes(0, rightBound, frogs);
                }
                case "Last" -> {
                    int count = Integer.parseInt(tokens[1]);
                    int startIndex = frogs.size() - count;

                    if (startIndex < 0) {
                        System.out.println(String.join(" ", frogs));
                    } else {
                        printCollectionByIndexes(startIndex, frogs.size(), frogs);
                    }
                }
            }
            input = scanner.nextLine();
        }
    }

    private static boolean isIndexValid(List<String> frogs, int index) {
        return index >= 0 && index < frogs.size();
    }

    private static void printCollection(List<String> frogs) {
        System.out.print("Frogs: ");
        System.out.print(String.join(" ", frogs));
    }

    private static void printCollectionByIndexes(int startIndex, int endIndex, List<String> frogs) {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.print(frogs.get(i) + " ");
        }
        System.out.println();
    }
}




