import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double price = 0;

        int people = Integer.parseInt(scanner.nextLine());
        String typeGroup = scanner.nextLine();
        String day = scanner.nextLine();

        switch (day) {
            case "Friday":
                if ("Students".equals(typeGroup)) {
                    price = people * 8.45;
                } else if ("Business".equals(typeGroup)) {
                    price = people * 10.90;
                    break;
                } else if ("Regular".equals(typeGroup)) {
                    price = people * 15;
                }
                break;
            case "Saturday":
                if ("Students".equals(typeGroup)) {
                    price = people * 9.80;
                } else if ("Business".equals(typeGroup)) {
                    price = people * 15.60;
                    break;
                } else if ("Regular".equals(typeGroup)) {
                    price = people * 20;
                }
                break;
            case "Sunday":
                if ("Students".equals(typeGroup)) {
                    price = people * 10.46;
                } else if ("Business".equals(typeGroup)) {
                    price = people * 16;
                    break;
                } else if ("Regular".equals(typeGroup)) {
                    price = people * 22.50;
                }
                break;
        }

        if (typeGroup.equals("Students") && people >= 30) {
            price *= 0.85;
        }

        if (typeGroup.equals("Business") && people >= 100) {
            price = (price / people) * (people - 10);
        }

        if (typeGroup.equals("Regular") && people >= 10 && people <= 20) {
            price *= 0.95;
        }

        System.out.printf("Total price: %.2f", price);
    }
}

