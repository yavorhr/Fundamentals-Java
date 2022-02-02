import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        char base = text.charAt(0);
        sb.append(base);

        for (int i = 0; i <text.length() ; i++) {
            char currentChar = text.charAt(i);
            if (currentChar!=base){
                sb.append(currentChar);
                base = currentChar;
            }
        }
        System.out.println(sb);
    }
}



