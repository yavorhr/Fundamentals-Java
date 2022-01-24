import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\s+");
        List<String> strings = new ArrayList<>();
        for (String s : line) {
            strings.add(s);
        }

        String command = scanner.nextLine();

        while (!"3:1".equals(command)) {
            String[] splitTheCommand = command.split("\\s+");

            switch (splitTheCommand[0]) {
                case "merge":

                    int startIndex = Integer.parseInt(splitTheCommand[1]);
                    int endIndex = Integer.parseInt(splitTheCommand[2]);

                    if (startIndex < 0) {
                        startIndex = 0;
                    }
                    if (endIndex > strings.size() - 1) {
                        endIndex = strings.size() - 1;
                    }
                    int counter = startIndex;

                    for (int i = startIndex; i < endIndex; i++) {
                        String concat = strings.get(counter) + strings.get(counter + 1);
                        strings.set(counter, concat);
                        strings.remove(counter + 1);
                    }
                    break;
                case "divide":
                    int index = Integer.parseInt(splitTheCommand[1]);
                    int partitions = Integer.parseInt(splitTheCommand[2]);

                    if (index >= 0 && index < strings.size() && partitions >= 0 && partitions <= 100) {
                        String element = strings.get(index);
                        List<String> newList = new ArrayList<>();

                        if (element.length() % partitions == 0) {
                            int portionLength = element.length() / partitions;
                            int count = 0;
                            for (int i = 0; i < partitions; i++) {
                                String concat = "";
                                for (int j = 0; j < portionLength; j++) {
                                    char symbol = element.charAt(count);
                                    concat += symbol;
                                    count++;
                                }
                                newList.add(concat);
                            }
                        } else {
                            int portionLength = element.length() / partitions;
                            int count = 0;
                            for (int i = 0; i < partitions; i++) {
                                String concat = "";

                                if (i == partitions - 1) {
                                    for (int j = count; j < element.length(); j++) {
                                        char symbol = element.charAt(count);
                                        concat += symbol;
                                        count++;
                                    }
                                } else {
                                    for (int j = 0; j < portionLength; j++) {
                                        char symbol = element.charAt(count);
                                        concat += symbol;
                                        count++;
                                    }
                                }
                                newList.add(concat);
                            }
                        }
                        strings.remove(index);
                        strings.addAll(index, newList);
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        for (String item : strings) {
            System.out.print(item + " ");
        }
    }
}



