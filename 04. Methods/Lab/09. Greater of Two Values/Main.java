import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        switch (type) {
            case "int":
                int numberOne = Integer.parseInt(scanner.nextLine());
                int numberTwo = Integer.parseInt(scanner.nextLine());
                int resultInt = getMax(numberOne, numberTwo);
                System.out.println(resultInt);
                break;
            case "char":
                char charOne = scanner.nextLine().charAt(0);
                char charTwo = scanner.nextLine().charAt(0);
                char resultChar = getMax(charOne, charTwo);
                System.out.println(resultChar);
                break;
            case "string":
                String stringOne = scanner.nextLine();
                String stringTwo = scanner.nextLine();
                String result = getMax(stringOne, stringTwo);
                System.out.println(result);
                break;
        }
    }

    private static int getMax(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    private static char getMax(char a, char b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    private static String getMax(String a, String b) {
        int firstOne = a.compareTo(b);
        if (firstOne > 0) {
            return a;
        }
        return b;
    }
}
