import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" ");
        int[] hours = new int[line.length];

        for (int i = 0; i < hours.length; i++) {
            hours[i] = Integer.parseInt(line[i]);
        }

        int droppedCnt = 0;
        int incompleteCnt = 0;
        int completedCnt = 0;

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" ");

            String command = tokens[0];

            switch (command) {
                case "Complete":
                    // "Complete {index}"
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < hours.length) {
                        hours[index] = 0;
                    }
                    break;
                case "Change":
                    //"Change {index} {time}"
                    index = Integer.parseInt(tokens[1]);
                    int time = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < hours.length) {
                        hours[index] = time;
                    }
                    break;
                case "Drop":
                    //•    "Drop {index}"
                    index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < hours.length) {
                        hours[index] = -1;
                    }
                    break;
                case "Count":
                    String todo = tokens[1];
                    if ("Dropped".equals(todo)) {
                        for (int i = 0; i < hours.length; i++) {
                            //Count Dropped"
                            if (hours[i] == -1) {
                                droppedCnt++;
                            }
                        }
                        System.out.println(droppedCnt);
                    } else if ("Completed".equals(todo)) {
                        // "Count Completed" - o  Print the number of completed tasks.
                        for (int i = 0; i < hours.length; i++) {
                            if (hours[i] == 0) {
                                completedCnt++;
                            }
                        }
                        System.out.println(completedCnt);
                    } else if ("Incomplete".equals(todo)) {
                        // "Count Incomplete" - Print the number of incomplete tasks (this doesn’t include the dropped tasks.
                        for (int i = 0; i < hours.length; i++) {
                            if (hours[i] > 0) {
                                incompleteCnt++;
                            }
                        }
                        System.out.println(incompleteCnt);
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 0) {
                System.out.print(hours[i] + " ");
            }
        }

    }
}




























