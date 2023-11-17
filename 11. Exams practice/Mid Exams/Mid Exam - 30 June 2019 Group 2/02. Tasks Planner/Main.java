import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> tasks = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Complete" -> {
                    int index = Integer.parseInt(tokens[1]);

                    if (isIndexValid(index, tasks)) {
                        tasks.set(index, 0);
                    }
                }
                case "Change" -> {
                    int index = Integer.parseInt(tokens[1]);
                    int time = Integer.parseInt(tokens[2]);

                    if (isIndexValid(index, tasks)) {
                        tasks.set(index, time);
                    }
                }
                case "Drop" -> {
                    int index = Integer.parseInt(tokens[1]);

                    if (isIndexValid(index, tasks)) {
                        tasks.set(index, -1);
                    }
                }
                case "Count" -> {
                    String condition = tokens[1];
                    printTasksPerCondition(condition, tasks);
                }
            }
            input = scanner.nextLine();
        }
        printAllIncompleteTasks(tasks);
    }

    private static boolean isIndexValid(int index, List<Integer> tasks) {
        return index >= 0 && index < tasks.size();
    }

    private static void printAllIncompleteTasks(List<Integer> tasks) {
        tasks.stream().filter(t -> t > 0).forEach(t -> System.out.print(t + " "));
    }

    private static void printTasksPerCondition(String condition, List<Integer> tasks) {
        switch (condition) {
            case "Completed" -> {
                System.out.println(tasks.stream().filter(t -> t == 0).count());
            }
            case "Incomplete" -> {
                System.out.println(tasks.stream().filter(t -> t > 0).count());
            }
            case "Dropped" -> {
                System.out.println(tasks.stream().filter(t -> t < 0).count());
            }
        }


    }
}




