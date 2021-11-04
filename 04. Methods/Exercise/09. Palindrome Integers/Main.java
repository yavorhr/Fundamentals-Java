import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String number = scan.nextLine();
        while (!number.equals("END")) {
            reversed(number);
            System.out.println(reversed(number));

            number = scan.nextLine();
        }
    }

    public static String reversed(String number) {

        String output = "";
        StringBuilder reversed = new StringBuilder();

        for (int i = number.length() - 1; i >= 0; i--) {
            reversed.append(number.charAt(i));
        }
        if (reversed.toString().equals(number)) {
            output = "true";
        } else {
            output = "false";
        }
        return output;

    }
}