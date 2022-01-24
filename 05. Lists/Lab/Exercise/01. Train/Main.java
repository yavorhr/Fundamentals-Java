import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] passengers = scanner.nextLine().split(" ");
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        List<Integer> wagon = new ArrayList<>();
        for (String passenger : passengers) {
            int passengerInt = Integer.parseInt(passenger);
            wagon.add(passengerInt);
        }

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] tokens = input.split(" ");
            if (tokens[0].equals("Add")) {
                int extraWagon = Integer.parseInt(tokens[1]);
                wagon.add(extraWagon);
            } else {
                int extraPassenger = Integer.parseInt(tokens[0]);
                for (int i = 0; i < wagon.size(); i++) {
                    if (maxCapacity - wagon.get(i) >= extraPassenger) {
                        wagon.set(i, wagon.get(i) + extraPassenger);
                        break;
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.println(wagon.toString().replaceAll("[\\[\\],]", ""));
    }
}






