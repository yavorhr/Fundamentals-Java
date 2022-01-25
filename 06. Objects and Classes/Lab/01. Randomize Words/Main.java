import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        Random randomWord = new Random();
        for (int i = 0; i < words.length; i++) {
            int randomIndex = randomWord.nextInt(words.length);

            String temp = words[i];
            words[i] = words[randomIndex];
            words[randomIndex] = temp;
        }

        for (String word : words) {
            System.out.println(word);
        }

    }
}








