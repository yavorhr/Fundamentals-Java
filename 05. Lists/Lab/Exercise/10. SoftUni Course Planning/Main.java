import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split(", ");
        List<String> lessons = new ArrayList<>();

        for (String singleText : text) {
            lessons.add(singleText);
        }

        String input = scanner.nextLine();

        while (!"course start".equals(input)) {
            String[] tokens = input.split(":");
            switch (tokens[0]) {
                case "Add":
                    if (!lessons.contains(tokens[1])) {
                        lessons.add(tokens[1]);
                    }
                    break;
                case "Insert":
                    if (!lessons.contains(tokens[1])) {
                        int index = Integer.parseInt(tokens[2]);
                        if (index >= 0 && index < lessons.size()) {
                            lessons.add(index, tokens[1]);
                        }
                    }
                    break;
                case "Remove":
                    lessons.remove(tokens[1]);
                    String ex = tokens[1] + "-Exercise";
                    lessons.remove(ex);
                    break;
                case "Swap":
                    String exOne = tokens[1] + "-Exercise";
                    String exTwo = tokens[2] + "-Exercise";

                    if (lessons.contains(tokens[1]) && lessons.contains(tokens[2])) {
                        String firstElement = tokens[1];
                        int firstIndex = lessons.indexOf(tokens[1]);
                        String secondElement = tokens[2];
                        int secondIndex = lessons.indexOf(tokens[2]);
                        lessons.set(firstIndex, secondElement);
                        lessons.set(secondIndex, firstElement);
                        if (lessons.contains(exOne)) {
                            lessons.remove(lessons.indexOf(exOne));
                            lessons.add(lessons.indexOf(tokens[1]) + 1, exOne);
                        }
                        if (lessons.contains(exTwo)) {
                            lessons.remove(lessons.indexOf(exTwo));
                            lessons.add(lessons.indexOf(tokens[2]) + 1, exTwo);
                        }
                    }
                    break;
                case "Exercise":
                    String ex1 = tokens[1] + "-Exercise";
                    if (!lessons.contains(tokens[1])) {
                        lessons.add(tokens[1]);
                        lessons.add(ex1);

                    } else if (lessons.contains(tokens[1]) && !lessons.contains(ex1)) {
                        int index = lessons.indexOf(tokens[1]);
                        lessons.add(index + 1, ex1);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < lessons.size(); i++) {
            System.out.println((i + 1) + "." + lessons.get(i));
        }
    }
}







