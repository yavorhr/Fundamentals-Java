import java.util.*;

public class Main {
    private final static int ARROW_POINTS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targets =
                Arrays.stream(scanner.nextLine()
                        .split("\\|"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int sumPoints = 0;

        String input = scanner.nextLine();

        while (!"Game over".equals(input)) {
            String[] tokens = input.split("@");
            String command = tokens[0];

            switch (command) {
                case "Shoot Left" -> {
                    int startIndexLeft = Integer.parseInt(tokens[1]);
                    int lengthLeft = Integer.parseInt(tokens[2]);

                    if (isIndexValid(targets, startIndexLeft)) {
                        int targetIndex = getIndexToTheLeft(targets, startIndexLeft, lengthLeft);
                        sumPoints = addTargetPoints(targets, sumPoints, targetIndex);
                    }
                }
                case "Shoot Right" -> {
                    int startIndexRight = Integer.parseInt(tokens[1]);
                    int lengthRight = Integer.parseInt(tokens[2]);

                    if (isIndexValid(targets, startIndexRight)) {
                        int targetIndex = startIndexRight + lengthRight;
                        targetIndex = getIndexToTheRight(targets, targetIndex);
                        sumPoints = addTargetPoints(targets, sumPoints, targetIndex);
                    }
                }
                case "Reverse" -> reverse(targets);
            }
            input = scanner.nextLine();
        }

        printResult(targets, sumPoints);
    }

    private static void printResult(int[] targets, int sumPoints) {
        Arrays.stream(targets).forEach(t -> System.out.print(t + " "));
        System.out.println();
        System.out.printf("Iskren finished the archery tournament with %d points!", sumPoints);
    }

    private static int getIndexToTheRight(int[] targets, int targetIndex) {
        while (targetIndex >= targets.length) {
            targetIndex -= targets.length;
        }
        return targetIndex;
    }

    private static int addTargetPoints(int[] targets, int sumPoints, int targetIndex) {
        if (targets[targetIndex] >= ARROW_POINTS) {
            targets[targetIndex] -= ARROW_POINTS;
            sumPoints += 5;
        } else if (targets[targetIndex] < ARROW_POINTS) {
            sumPoints += targets[targetIndex];
            targets[targetIndex] = 0;
        }
        return sumPoints;
    }

    private static int getIndexToTheLeft(int[] targets, int startIndexLeft, int lengthLeft) {
        int targetIndex = startIndexLeft - lengthLeft;
        while (targetIndex < 0) {
            targetIndex = targets.length + targetIndex;
        }
        return targetIndex;
    }

    private static boolean isIndexValid(int[] targets, int startIndexLeft) {
        return startIndexLeft >= 0 && startIndexLeft < targets.length;
    }

    private static void reverse(int[] targets) {
        for (int i = 0; i < targets.length / 2; i++) {
            int temp = targets[i];
            int swapIndex = targets.length - 1 - i;
            targets[i] = targets[swapIndex];
            targets[swapIndex] = temp;
        }
    }
}


