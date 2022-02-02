import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int power = 0;
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '>') {
                power += Integer.parseInt(String.valueOf(input.charAt(i + 1)));
                result.append('>');
            } else if (power == 0) {
                result.append(currentChar);
            } else {
                power--;
            }
        }
        System.out.println(result);
    }
}

