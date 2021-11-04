import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();
        findTheVowels(input);
    }

    private static void findTheVowels(String input) {
        int length = input.length();
        int count = 0;

        for (int i = 0; i < length; i++) {
            String letter = "" + input.charAt(i);

            switch (letter) {
                case "a":
                    count++;
                    break;
                case "o":
                    count++;
                    break;
                case "u":
                    count++;
                    break;
                case "i":
                    count++;
                    break;
                case "e":
                    count++;
                    break;
                case "y":
                    count++;
                    break;
            }
        }
        System.out.println(count);
    }
}
