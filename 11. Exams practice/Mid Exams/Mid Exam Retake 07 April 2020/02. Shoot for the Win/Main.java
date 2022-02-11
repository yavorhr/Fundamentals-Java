import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] targets = new int[input.length];
        int counter = 0;

        for (int i = 0; i < targets.length; i++) {
            targets[i] = Integer.parseInt(input[i]);
        }

        String command = scanner.nextLine();
        while (!"End".equals(command)) {
            int indexTarget = Integer.parseInt(command);

            if (indexTarget >= 0 && indexTarget < targets.length) {
                for (int i = 0; i < targets.length; i++) {
                    int temp = targets[indexTarget];                       //за числото

                    if (targets[i] != -1 && indexTarget != i) {
                        if (targets[i] > temp) {
                            targets[i] -= temp;
                        } else if (targets[i] <= temp) {
                            targets[i] += temp;
                        }
                    }
                }
                targets[indexTarget] = -1;
                counter++;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", counter);
        for (int i = 0; i < targets.length; i++) {
            System.out.print(targets[i] + " ");
        }
    }
}










































