import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = readDoubleFromConsole(scanner);
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double lightSaberPrice = readDoubleFromConsole(scanner);
        double robePrice = readDoubleFromConsole(scanner);
        double beltPrice = readDoubleFromConsole(scanner);

        double totalAmount = calculateTotalAmount(studentsCount, lightSaberPrice, robePrice, beltPrice);
        printResult(budget, totalAmount);
    }

    private static void printResult(double budget, double totalAmount) {
        if (budget >= totalAmount) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalAmount);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", Math.abs(totalAmount - budget));
        }
    }

    private static double calculateTotalAmount(int studentsCount, double lightSaberPrice, double robePrice, double beltPrice) {
        double beltsAmount = calculateBeltsAmount(studentsCount, beltPrice);
        double lightSabersAmount = calculateLightSabersAmount(studentsCount, lightSaberPrice);
        double robesAmount = calculateRobesAmount(studentsCount, robePrice);

        return beltsAmount + lightSabersAmount + robesAmount;
    }

    private static double calculateRobesAmount(int studentsCount, double robePrice) {
        return studentsCount * robePrice;
    }

    private static double calculateBeltsAmount(int studentsCount, double beltPrice) {
        double beltsTotalAmount = studentsCount * beltPrice;
        int beltsCount = studentsCount / 6;
        if (beltsCount > 0) {
            beltsTotalAmount -= beltsCount * beltPrice;
        }
        return beltsTotalAmount;
    }

    private static double calculateLightSabersAmount(int studentsCount, double lightSaberPrice) {
        double additionalPercent = Math.ceil(studentsCount + studentsCount * 0.1);
        return additionalPercent * lightSaberPrice;
    }

    private static double readDoubleFromConsole(Scanner scanner) {
        return Double.parseDouble(scanner.nextLine());
    }
}