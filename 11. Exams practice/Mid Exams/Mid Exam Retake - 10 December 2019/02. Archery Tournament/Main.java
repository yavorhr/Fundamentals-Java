import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersAstext = scanner.nextLine().split("\\|");
        int targetsNumbers[] = new int[numbersAstext.length];

        for (int i = 0; i < numbersAstext.length; i++) {
            targetsNumbers[i] = Integer.parseInt(numbersAstext[i]);
        }

        int sumPoints = 0;

        String input = scanner.nextLine();
        while (!"Game over".equals(input)) {
            String[] token = input.split("\\@");
            String direction = token[0];
            if (direction.equals("Shoot Left")) {
                int startIndexLeft = Integer.parseInt(token[1]);
                int lengthLeft = Integer.parseInt(token[2]);
                if (startIndexLeft >= 0 && startIndexLeft < numbersAstext.length) {
                    int targetIndex = startIndexLeft - lengthLeft;
                    while (targetIndex < 0) {
                        targetIndex = targetsNumbers.length + targetIndex;
                    }

                    if (targetsNumbers[targetIndex] > 5) {
                        targetsNumbers[targetIndex] = targetsNumbers[targetIndex] - 5;
                        sumPoints += 5;
                    } else if (targetsNumbers[targetIndex] < 5) {
                        sumPoints += targetsNumbers[targetIndex];
                        targetsNumbers[targetIndex] = 0;
                    }
                }
            } else if (direction.equals("Shoot Right")) {
                int startIndexRight = Integer.parseInt(token[1]);
                int lengthRight = Integer.parseInt(token[2]);
                if (startIndexRight >= 0 && startIndexRight < numbersAstext.length) {
                    int targetIndex = startIndexRight + lengthRight;
                    while (targetIndex >= targetsNumbers.length) {
                        targetIndex -= targetsNumbers.length;
                    }
                    if (targetsNumbers[targetIndex] > 5) {
                        targetsNumbers[targetIndex] -= 5;
                        sumPoints += 5;
                    } else if (targetsNumbers[targetIndex] < 5) {
                        sumPoints += targetsNumbers[targetIndex];
                        targetsNumbers[targetIndex] = 0;
                    }
                }
            } else if (direction.equals("Reverse")) {
                reverse(targetsNumbers);
            }
            input = scanner.nextLine();
        }

        for (int i = 0; i < targetsNumbers.length - 1; i++) {
            System.out.print(targetsNumbers[i] + " - ");
        }

        System.out.println(targetsNumbers[targetsNumbers.length - 1]);
        System.out.printf("Iskren finished the archery tournament with %d points!%n", sumPoints);
    }

    private static int[] reverse(int[] targetsNumbers) {
        for (int i = 0; i < targetsNumbers.length / 2; i++) {
            int temp = targetsNumbers[i];
            int swapIndex = targetsNumbers.length - 1 - i;
            targetsNumbers[i] = targetsNumbers[swapIndex];
            targetsNumbers[swapIndex] = temp;
        }
        return targetsNumbers;
    }
}















