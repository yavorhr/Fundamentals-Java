import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());
        int peopleCount = Integer.parseInt(scanner.nextLine());
        double fuelPerKm = Double.parseDouble(scanner.nextLine());
        double foodPerPerson = Double.parseDouble(scanner.nextLine());
        double pricePerPersonForNight = Double.parseDouble(scanner.nextLine());

        double totalFood = days * peopleCount * foodPerPerson;
        double totalNights = days * peopleCount * pricePerPersonForNight;

        if (peopleCount > 10) {
            totalNights *= 0.75;
        }

        double expenses = totalFood + totalNights;
        boolean isSuccessful = true;

        for (int i = 1; i <= days; i++) {
            double travelledKm = Double.parseDouble(scanner.nextLine());
            expenses += travelledKm * fuelPerKm;

            if (i % 3 == 0 || i % 5 == 0) {
                expenses *= 1.4;
            }
            if (i % 7 == 0) {
                double reduceAmount = expenses / peopleCount;
                expenses -= reduceAmount;
            }

            if (expenses > budget) {
                isSuccessful = false;
                break;
            }
        }

        if (isSuccessful) {
            System.out.printf("You have reached the destination. You have %.2f$ budget left.", budget-expenses);
        } else {
            System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", expenses-budget);
        }

    }
}




