import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("#");
        int water = Integer.parseInt(scanner.nextLine());

        List<Integer> result = new ArrayList<>();
        double effort = 0;

        for (int i = 0; i < input.length; i++) {
            String[] cellSplit = input[i].split(" = ");
            String typeOfFire = cellSplit[0];
            int value = Integer.parseInt(cellSplit[1]);
            switch (typeOfFire) {
                case "High":
                    if (value >= 81 && value <= 125 && water - value >= 0) {
                        result.add(value);
                        water -= value;
                        double currentEffort = value * 0.25;
                        effort += currentEffort;
                    }
                    break;
                case "Medium":
                    if (value >= 51 && value <= 80 && water - value >= 0) {
                        result.add(value);
                        water -= value;
                        double currentEffort = value * 0.25;
                        effort += currentEffort;
                    }
                    break;
                case "Low":
                    if (value >= 1 && value <= 50 && water - value >= 0) {
                        result.add(value);
                        water -= value;
                        double currentEffort = value * 0.25;
                        effort += currentEffort;
                        break;
                    }
            }
        }

        int sum = 0;
        System.out.println("Cells:");
        for (int i = 0; i < result.size(); i++) {
            sum += result.get(i);
            System.out.printf(" - %d%n", result.get(i));

        }

        System.out.printf("Effort: %.2f%n", effort);
        System.out.printf("Total Fire: %d", sum);

    }
}



































