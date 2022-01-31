import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!"end".equals(command)) {
            String reverse = "";
            for (int i = command.length() - 1; i >= 0; i--) {
                reverse += command.charAt(i);
            }
            System.out.printf("%s = %s%n", command, reverse);
            command = scanner.nextLine();
        }
    }
}


