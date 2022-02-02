import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        String firstWord = words[0];
        String secondWord = words[1];

        int min = Math.min(firstWord.length(), secondWord.length());
        int max = Math.max(firstWord.length(), secondWord.length());

        int result = 0;

        for (int i = 0; i < max; i++) {
            if (i < min) {
                result += firstWord.charAt(i) * secondWord.charAt(i);
            } else if (firstWord.length() == max){
                result += firstWord.charAt(i);
            } else {
                result += secondWord.charAt(i);
            }
        }

        System.out.println(result);
    }
}

