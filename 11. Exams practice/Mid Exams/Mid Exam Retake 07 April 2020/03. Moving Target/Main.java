import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split(" ");
        List<Integer> targets = new ArrayList<>();

        for (String s : text) {
            int currentTarget = Integer.parseInt(s);
            targets.add(currentTarget);
        }

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            int index = Integer.parseInt(tokens[1]);

            switch (command) {
                case "Shoot":
                    int power = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < targets.size()) {
                        int currentTarget = targets.get(index);
                        targets.set(index, currentTarget - power);
                        if (targets.get(index) <= 0) {
                            targets.remove(index);
                        }
                    }
                    break;
                case "Add":
                    if (index >= 0 && index < targets.size()) {
                        int value = Integer.parseInt(tokens[2]);
                        targets.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int radius = Integer.parseInt(tokens[2]);
                    int strikeIndex = index;

                    if (strikeIndex - radius >= 0 && strikeIndex + radius < targets.size()) {
                        int startIndex = strikeIndex - radius;
                        int endIndex = strikeIndex + radius;
                        for (int i = endIndex; i >= startIndex; i--) {
                            targets.remove(i);
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        List<String> result = new ArrayList<>();
        for (int target : targets
        ) {
            String targetAsString = target + "";
            result.add(targetAsString);
        }
        System.out.println(String.join("|", result));
    }
}





