import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagonsWithPassengers = readListOfInts(scanner);
        int wagonCapacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split(" ");

            if (tokens[0].equals("Add")) {
                int newPassengers = Integer.parseInt(tokens[1]);
                addMoreWagonsWithPassengers(wagonsWithPassengers, newPassengers);
            } else {
                int newPassengers = Integer.parseInt(tokens[0]);
                addPassengersToAWagon(wagonsWithPassengers, wagonCapacity, newPassengers);
            }
            input = scanner.nextLine();
        }
        printResult(wagonsWithPassengers);
    }

    private static void addPassengersToAWagon(List<Integer> wagonsWithPassengers, int wagonCapacity, int newPassengers) {
        for (int i = 0; i < wagonsWithPassengers.size(); i++) {
            int currentPassengers = wagonsWithPassengers.get(i);

            if (currentPassengers + newPassengers <= wagonCapacity) {
                wagonsWithPassengers.set(i, currentPassengers+ newPassengers);
                break;
            }
        }
    }

    private static void addMoreWagonsWithPassengers(List<Integer> wagonsWithPassengers, int passengers) {
        wagonsWithPassengers.add(passengers);
    }

    private static List<Integer> readListOfInts(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void printResult(List<Integer> list){
        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
    }
}
