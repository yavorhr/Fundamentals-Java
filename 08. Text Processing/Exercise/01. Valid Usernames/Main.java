import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split(", ");
        for (String word : text) {
            if (wordIsValid(word)){
                System.out.println(word);
            }
        }
    }

    private static boolean wordIsValid(String word) {
        if (word.length()<3 || word.length()>16){
            return false;
        }

        for (int i = 0; i <word.length() ; i++) {
            char currentCh = word.charAt(i);
            if (!Character.isLetterOrDigit(currentCh) && currentCh != '-' && currentCh != '_'){
                return false;
            }
        } return true;
    }
}

