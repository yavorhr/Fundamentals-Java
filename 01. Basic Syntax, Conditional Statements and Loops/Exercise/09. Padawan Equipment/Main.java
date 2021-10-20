import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceSabre = Double.parseDouble(scanner.nextLine());     //total sabres + 10%
        double priceRobes = Double.parseDouble(scanner.nextLine());
        double priceBelt = Double.parseDouble(scanner.nextLine());      //every 6 is free

        int freeBelt = students / 6;
        double belts = (priceBelt * students) - freeBelt * priceBelt;
        double sabres = (Math.ceil(students * 1.1)) * priceSabre;
        double robes = priceRobes * students;

        double costs = belts + sabres + robes;

        if (budget >= costs) {
            System.out.printf("The money is enough - it would cost %.2flv.", costs);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", costs - budget);
        }

    }
}
