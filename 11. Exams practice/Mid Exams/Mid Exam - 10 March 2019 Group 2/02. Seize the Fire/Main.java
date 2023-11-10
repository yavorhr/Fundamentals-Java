import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("#");
        int water = Integer.parseInt(scanner.nextLine());
        double effort = 0;

        List<Integer> cells = new ArrayList<>();

        for (String s : input) {
            String[] tokens = s.split(" ");
            String typeOfFire = tokens[0];
            int range = Integer.parseInt(tokens[2]);

            switch (typeOfFire) {
                case "High" -> {
                    if (checkRange(range, 81, 125)) {
                        if (isWaterSufficient(water, range)) {
                            water = subtractWater(water, range);
                            effort = addEffort(effort, range);
                            cells.add(range);
                        }
                    }
                }
                case "Medium" -> {
                    if (checkRange(range, 51, 80)) {
                        if (isWaterSufficient(water, range)) {
                            water = subtractWater(water, range);
                            effort = addEffort(effort, range);
                            cells.add(range);
                        }
                    }
                }
                case "Low" -> {
                    if (checkRange(range, 1, 50)) {
                        if (isWaterSufficient(water, range)) {
                            water = subtractWater(water, range);
                            effort = addEffort(effort, range);
                            cells.add(range);
                        }
                    }
                }
            }
        }
        printResult(cells, effort);
    }

    private static double addEffort(double effort, int range) {
        effort += 0.25 * range;
        return effort;
    }

    private static int subtractWater(int water, int range) {
        water -= range;
        return water;
    }

    private static boolean isWaterSufficient(int water, int range) {
        return water - range > 0;
    }

    private static void printResult(List<Integer> cells, double effort) {
        System.out.println("Cells:");
        cells.forEach(s -> System.out.printf("- %d\n", s));
        System.out.printf("Effort: %.2f\n", effort);

        int sum = cells.stream().reduce(0, (a, b) -> a + b);
        System.out.printf("Total Fire: %d", sum);
    }

    private static boolean checkRange(int range, int lowBound, int highBound) {
        return range >= lowBound && range <= highBound;
    }
}



