import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfTheDay = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        String result = getPrice(typeOfTheDay, age);

        System.out.println(result);
    }

    private static String getPrice(String typeOfTheDay, int age) {
        String price = "";

        switch (typeOfTheDay) {
            case "Weekday":
                if (age >= 0 && age <= 18) {
                    price = "12$";
                } else if (age > 18 && age <= 64) {
                    price = "18$";
                } else if (age > 64 && age <= 122) {
                    price = "12$";
                }
                break;
            case "Weekend":
                if (age >= 0 && age <= 18) {
                    price = "15$";
                } else if (age > 18 && age <= 64) {
                    price = "20$";
                } else if (age > 64 && age <= 122) {
                    price = "15$";
                }
                break;
            case "Holiday":
                if (age >= 0 && age <= 18) {
                    price = "5$";
                } else if (age > 18 && age <= 64) {
                    price = "12$";
                } else if (age > 64 && age <= 122) {
                    price = "10$";
                }
                break;
        }

        if (age < 0 || age > 122) {
            return "Error!";
        }
        return price;
    }
}
