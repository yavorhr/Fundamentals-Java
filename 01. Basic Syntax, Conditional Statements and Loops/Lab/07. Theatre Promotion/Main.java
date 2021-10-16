import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfDay = scanner.nextLine().toLowerCase();
        int age = Integer.parseInt(scanner.nextLine());

        double price = 0;

        switch (typeOfDay) {
            case "weekday":
                if (age <= 18 && age >= 0) {
                    price = 12;
                } else if (age > 18 && age <= 64) {
                    price = 18;
                } else if (age > 64 && age <= 122) {
                    price = 12;
                }
                break;
            case "holiday":
                if (age <= 18 && age >= 0) {
                    price = 5;
                } else if (age > 18 && age <= 64) {
                    price = 12;
                } else if (age > 64 && age <= 122) {
                    price = 10;
                }
                break;
            case "weekend":
                if (age <= 18 && age >= 0) {
                    price = 15;
                } else if (age > 18 && age <= 64) {
                    price = 20;
                } else if (age > 64 && age <= 122) {
                    price = 15;
                }
                break;
        }

        if (price != 0) {
            System.out.printf("%.0f$", price);
        } else {
            System.out.println("Error!");
        }

    }
}

