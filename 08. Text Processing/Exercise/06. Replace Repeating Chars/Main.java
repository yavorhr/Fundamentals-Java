import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder result = new StringBuilder();
        char base = input.charAt(0);
        result.append(base);

        replaceRepeatingChars(result,base,input);

        printResult(result);
    }

    private static void printResult(StringBuilder result) {
        System.out.println(result);
    }

    private static void replaceRepeatingChars(StringBuilder sb, char base, String input){
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar != base) {
                sb.append(currentChar);
                base = currentChar;
            }
        }

    }
}

