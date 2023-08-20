import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String weekDay = scanner.nextLine();

        printResult(peopleCount, typeOfGroup, weekDay);

    }

    private static void printResult(int peopleCount, String typeOfGroup, String weekDay) {
        double ticketPrice = 0.0;
        double totalPrice = 0.0;

        switch (weekDay) {
            case "Friday":
                if (typeOfGroup.equals("Students")) {
                    ticketPrice = 8.45;
                    totalPrice = calcStudentsDiscount(ticketPrice, peopleCount);
                } else if (typeOfGroup.equals("Business")) {
                    ticketPrice = 10.90;
                    totalPrice = calcBusinessDiscount(ticketPrice, peopleCount);
                } else if (typeOfGroup.equals("Regular")) {
                    ticketPrice = 15.00;
                    totalPrice = calcRegularDiscount(ticketPrice, peopleCount);
                }
                break;
            case "Saturday":
                if (typeOfGroup.equals("Students")) {
                    ticketPrice = 9.80;
                    totalPrice = calcStudentsDiscount(ticketPrice, peopleCount);
                } else if (typeOfGroup.equals("Business")) {
                    ticketPrice = 15.60;
                    totalPrice = calcBusinessDiscount(ticketPrice, peopleCount);
                } else if (typeOfGroup.equals("Regular")) {
                    ticketPrice = 20.00;
                    totalPrice = calcRegularDiscount(ticketPrice, peopleCount);
                }
                break;
            case "Sunday":
                if (typeOfGroup.equals("Students")) {
                    ticketPrice = 10.46;
                    totalPrice = calcStudentsDiscount(ticketPrice, peopleCount);
                } else if (typeOfGroup.equals("Business")) {
                    ticketPrice = 16.00;
                    totalPrice = calcBusinessDiscount(ticketPrice, peopleCount);
                } else if (typeOfGroup.equals("Regular")) {
                    ticketPrice = 22.50;
                    totalPrice = calcRegularDiscount(ticketPrice, peopleCount);

                }
                break;
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }

    private static double calcStudentsDiscount(double ticketPrice, int peopleCount) {
        double totalPrice = calcTotalAmount(ticketPrice, peopleCount);
        if (peopleCount >= 30) {
            totalPrice -= totalPrice * 0.15;
        }
        return totalPrice;
    }

    private static double calcBusinessDiscount(double ticketPrice, int peopleCount) {
        double totalPrice = calcTotalAmount(ticketPrice, peopleCount);
        if (peopleCount >= 100) {
            totalPrice -= ticketPrice * 10;
        }
        return totalPrice;
    }

    private static double calcRegularDiscount(double ticketPrice, int peopleCount) {
        double totalPrice = calcTotalAmount(ticketPrice, peopleCount);
        if (peopleCount >= 10 && peopleCount <= 20) {
            totalPrice -= totalPrice * 0.05;
        }
        return totalPrice;
    }

    private static double calcTotalAmount(double ticketPrice, int peopleCount) {
        return ticketPrice * peopleCount;
    }
}