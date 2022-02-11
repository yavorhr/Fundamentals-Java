import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputText = scanner.nextLine().split("\\s+");
        List<String> collection = new ArrayList<>();
        collection.addAll(Arrays.asList(inputText));

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Change":
                    String paintingNumber = tokens[1];
                    int index = collection.indexOf(paintingNumber);
                    String changeNumber = tokens[2];
                    if (collection.contains(paintingNumber)) {
                        collection.set(index, changeNumber);
                    }
                    break;
                case "Hide":
                    String paintingToHide = tokens[1];
                    if (collection.contains(paintingToHide)) {
                        collection.remove(paintingToHide);
                    }
                    break;
                case "Switch":
                    String paintingOne = tokens[1];
                    String paintingTwo = tokens[2];
                    if (collection.contains(paintingTwo) && collection.contains(paintingOne)) {
                        int indexOne = collection.indexOf(paintingOne);
                        int indexTwo = collection.indexOf(paintingTwo);
                        Collections.swap(collection, indexOne, indexTwo);
                    }
                    break;
                case "Insert":
                    int place = Integer.parseInt(tokens[1]);
                    int desiredIndex = place + 1;
                    String paintingToInsert = tokens[2];
                    if (desiredIndex >= 0 && desiredIndex < collection.size()) {
                        collection.add(desiredIndex, paintingToInsert);
                    }
                    break;
                case "Reverse":
                    Collections.reverse(collection);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(String.join(" ", collection));
    }
}








































