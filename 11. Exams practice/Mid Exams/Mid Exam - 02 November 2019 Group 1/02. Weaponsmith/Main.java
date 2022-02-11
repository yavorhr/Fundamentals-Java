import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] syllables = scanner.nextLine().split("\\|");

        String input = scanner.nextLine();
        while (!"Done".equals(input)) {
            String[] token = input.split(" ");
            String command = token[0];

            switch (command) {
                case "Move":
                    String direction = token[1];
                    int index = Integer.parseInt(token[2]);

                    if (direction.equals("Left")) {
                        if (index > 0 && index <= syllables.length - 1) {
                            String temp = syllables[index];
                            syllables[index] = syllables[index - 1];
                            syllables[index - 1] = temp;
                        }
                    } else if (direction.equals("Right")) {
                        if (index >= 0 && index < syllables.length - 1) {
                            String temp = syllables[index];
                            syllables[index] = syllables[index + 1];
                            syllables[index + 1] = temp;
                        }
                    }
                    break;
                case "Check":
                    String numberType = token[1];
                    if (numberType.equals("Odd")) {
                        for (int i = 1; i <= syllables.length - 1; i++) {
                            if (i % 2 != 0) {
                                System.out.print(syllables[i] + " ");
                            }
                        }
                    } else if (numberType.equals("Even")) {
                        for (int i = 1; i <= syllables.length - 1; i++) {
                            if (i % 2 == 0) {
                                System.out.print(syllables[i] + " ");
                            }
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println();
        System.out.println("You crafted " + String.join("", syllables) + "!");
    }
}


















