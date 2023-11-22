import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String firstWord = input[0];
        String secondWord = input[1];

        int max = Math.max(firstWord.length(), secondWord.length());
        int min = Math.min(firstWord.length(), secondWord.length());

        int sumChars = 0;
        sumChars = getSumChars(firstWord, secondWord, max, min, sumChars);

        printSum(sumChars);
    }

    private static void printSum(int sumChars) {
        System.out.println(sumChars);
    }

    private static int getSumChars(String firstWord, String secondWord, int max, int min, int sumChars) {
        for (int i = 0; i < max; i++) {
            if (i < min) {
                sumChars += firstWord.charAt(i) * secondWord.charAt(i);
            } else if (firstWord.length() == max){
                sumChars += firstWord.charAt(i);
            } else {
                sumChars += secondWord.charAt(i);
            }
        }
        return sumChars;
    }
}