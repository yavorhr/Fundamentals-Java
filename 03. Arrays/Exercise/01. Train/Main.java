import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countWagons = Integer.parseInt(scanner.nextLine());
        int[] peopleInTrain = initArray(scanner, countWagons);

        printPeoplePerWagon(peopleInTrain);

        System.out.println();

        int sumPeople = Arrays.stream(peopleInTrain).sum();
        System.out.println(sumPeople);
    }

    private static void printPeoplePerWagon(int[] allPeopleInTrain) {
        Arrays.stream(allPeopleInTrain)
                .forEach(value -> System.out.print(value + " "));
    }

    private static int[] initArray(Scanner scanner, int countWagons) {
        int[] allPeopleInTrain = new int[countWagons];

        for (int i = 0; i < countWagons; i++) {
            int currentPeople = Integer.parseInt(scanner.nextLine());
            allPeopleInTrain[i] = currentPeople;
        }

        return allPeopleInTrain;
    }
}
