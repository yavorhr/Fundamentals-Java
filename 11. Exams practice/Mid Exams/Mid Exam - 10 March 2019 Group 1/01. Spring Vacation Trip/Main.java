import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());
        int peopleCnt = Integer.parseInt(scanner.nextLine());
        double priceFuelPerKm = Double.parseDouble(scanner.nextLine());
        double singleFoodExpenses = Double.parseDouble(scanner.nextLine());
        double singleRoomExpensesPerNight = Double.parseDouble(scanner.nextLine());

        double nights = days * peopleCnt * singleRoomExpensesPerNight;
        if (peopleCnt > 10) {
            nights *= 0.75;
        }
        double food = days * peopleCnt * singleFoodExpenses;
        double expenses = food + nights;
        boolean isSucessful = true;

        for (int i = 1; i <= days; i++) {

            double distanceKm = Double.parseDouble(scanner.nextLine());
            expenses += distanceKm * priceFuelPerKm;

            if (i % 3 == 0 || i % 5 == 0) {
                expenses *= 1.4;
            }
            if (i % 7 == 0) {
                expenses -= expenses / peopleCnt;
            }
            if (expenses > budget) {
                isSucessful = false;
                break;
            }
        }

        if (isSucessful) {
            System.out.printf("You have reached the destination. You have %.2f$ budget left.", budget - expenses);
        } else {
            System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", expenses - budget);
        }

    }
}




































