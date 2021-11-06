import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        int n = scanner.nextInt();

        String repeated = repeatString(string, n);
        System.out.println(repeated);
    }

    private static String repeatString(String string, int n) {

        String[] repeatArr = new String[n];
        for (int i = 0; i < repeatArr.length; i++) {
            repeatArr[i] = string;
        }

        return String.join("", repeatArr);
    }
}
