import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] frogsArray = scanner.nextLine().split(" ");
        List<String> frogs = new ArrayList<>();
        frogs.addAll(Arrays.asList(frogsArray));
        
        while (true) {
            String[] tokens = scanner.nextLine().split(" ");
            String command = tokens[0];
            String name = tokens[1];

            if (command.equals("Print")) {
                String type = tokens[1];
                if (type.equals("Reversed")) {
                    System.out.print("Frogs: ");
                    Collections.reverse(frogs);
                    System.out.println(String.join(" ", frogs));
                    break;
                } else if (type.equals("Normal")) {
                    System.out.print("Frogs: ");
                    System.out.println(String.join(" ", frogs));
                    break;
                }
            }

            switch (command) {
                case "Join":
                    frogs.add(name);
                    break;
                case "Jump":
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < frogs.size()) {
                        frogs.add(index, name);
                    }
                    break;
                case "Dive":
                    int indexToDive = Integer.parseInt(tokens[1]);
                    if (indexToDive >= 0 && indexToDive < frogs.size()) {
                        frogs.remove(indexToDive);
                    }
                    break;
                case "First":
                    int countFirst = Integer.parseInt(tokens[1]);
                    int rightBound = Math.min(frogs.indexOf(0) + countFirst, frogs.size() - 1);
                    for (int i = 0; i <= rightBound; i++) {
                        System.out.print(frogs.get(i) + " ");
                    }
                    System.out.println();
                    break;
                case "Last":
                    int countLast = Integer.parseInt(tokens[1]);
                    int startIndex = frogs.size() - countLast;

                    if (startIndex < 0) {
                        System.out.println(String.join(" ", frogs));
                    } else {
                        for (int i = startIndex; i < frogs.size() ; i++) {
                            System.out.print(frogs.get(i) + " ");
                        }
                        System.out.println();
                    }
                    break;
            }
        }

    }
}





























