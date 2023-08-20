import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());

        printResult(age);
    }

    private static void printResult(int age) {
        String result = "";

        if (age > 0 && age <= 2) {
            result = "baby";
        } else if (age > 2 && age <= 13) {
            result = "child";
        } else if (age > 13 && age <= 19) {
            result = "teenager";
        } else if (age > 19 && age <= 65) {
            result = "adult";
        } else {
            result = "elder";
        }
        System.out.println(result);
    }
}