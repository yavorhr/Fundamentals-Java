import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        randomizeArrayElements(words);
        printResult(words);
    }

    private static void printResult(String[] words) {
        for (String word : words) {
            System.out.println(word);
        }
    }

    private static void randomizeArrayElements(String[] array) {
        Random rnd = new Random();

        for (int i = 0; i < array.length; i++) {
            int randomIndex = rnd.nextInt(array.length);

            String temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }
}

