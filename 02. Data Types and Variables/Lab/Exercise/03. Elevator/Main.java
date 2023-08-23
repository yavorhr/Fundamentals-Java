import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());

        String result = capacityCheck(numberOfPeople, capacity);
        System.out.println(result);
    }

    private static String capacityCheck(int numberOfPeople, int capacity) {
        String result = "";

        if (numberOfPeople < capacity) {
            result = "All the persons fit inside in the elevator.";
        } else {
            int courses = numberOfPeople / capacity;
            int remainPeople = numberOfPeople % capacity;

            if (remainPeople > 0) {
                courses = courses + 1;
            }
            result = courses + "";
        }
        return result;
    }
}

