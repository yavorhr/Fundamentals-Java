import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tanksText = scanner.nextLine().split(", ");
        List<String> tanks = new ArrayList<>();
        tanks.addAll(Arrays.asList(tanksText));

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(", ");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    String tankToAdd = tokens[1];
                    if (!tanks.contains(tankToAdd)) {
                        System.out.println("Tank successfully bought");
                        tanks.add(tankToAdd);
                    } else {
                        System.out.println("Tank is already bought");
                    }
                    break;
                case "Remove":
                    String tankToRemove = tokens[1];
                    if (tanks.contains(tankToRemove)) {
                        System.out.println("Tank successfully sold");
                        tanks.remove(tankToRemove);
                    } else {
                        System.out.println("Tank not found");
                    }
                    break;
                case "Remove At":
                    int indexToRemove = Integer.parseInt(tokens[1]);
                    if (indexToRemove >= 0 && indexToRemove < tanks.size()) {
                        tanks.remove(indexToRemove);
                        System.out.println("Tank successfully sold");
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;
                case "Insert":
                    int indexToInsert = Integer.parseInt(tokens[1]);
                    String newTank = tokens[2];
                    if (indexToInsert >= 0 && indexToInsert < tanks.size() && !tanks.contains(newTank)) {
                        tanks.add(indexToInsert, newTank);
                        System.out.println("Tank successfully bought");
                    } else if (indexToInsert >= 0 && indexToInsert < tanks.size() && tanks.contains(newTank)) {
                        System.out.println("Tank is already bought");
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;
            }
        }
        System.out.println(String.join(", ", tanks));
    }
}



















