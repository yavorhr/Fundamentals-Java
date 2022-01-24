import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsCount = Integer.parseInt(scanner.nextLine());
        List<String> guests = new ArrayList<>();

        for (int i = 0; i < commandsCount; i++) {
            String[] tokens = scanner.nextLine().split("\\s+",2);
            String name = tokens[0];
            String goingOrNot = tokens[1];

            switch (goingOrNot) {
                case "is going!":
                    if (guests.contains(name)) {
                        System.out.printf("%s is already in the list!%n", name);
                    } else {
                        guests.add(name);
                    }
                    break;
                case "is not going!":
                    if (guests.contains(name)) {
                        guests.remove(name);
                    } else {
                        System.out.printf("%s is not in the list!%n", name);
                    }
                    break;
            }
        }
        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}






