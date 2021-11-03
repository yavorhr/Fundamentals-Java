import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] parts = scanner.nextLine().split(" ");

        for (int i = 0; i < parts.length / 2; i++) {
            int swapIndex = parts.length - 1 - i;
            String tmp = parts[i];
            parts[i] = parts[swapIndex];
            parts[swapIndex] = tmp;
        }

        System.out.println(String.join(" ", parts));
    }
}
