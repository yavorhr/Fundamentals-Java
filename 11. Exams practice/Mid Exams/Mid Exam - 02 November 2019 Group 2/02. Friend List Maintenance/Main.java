import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(", ");
        int blackListedCnt = 0;
        int lostNames = 0;

        String input = scanner.nextLine();
        while (!"Report".equals(input)) {
            String[] token = input.split(" ");
            String command = token[0];
            boolean notFound = true;

            switch (command) {
                case "Blacklist":
                    String name = (token[1]);
                    for (int i = 0; i < names.length; i++) {
                        if (!(names[i].equals("Blacklisted") || names[i].equals("Lost"))) {
                            if (names[i].equals(name)) {
                                System.out.printf("%s was blacklisted.%n", names[i]);
                                names[i] = "Blacklisted";
                                notFound = false;
                                blackListedCnt++;
                                break;
                            }
                        }
                    }
                    break;
                case "Error":
                    int index = Integer.parseInt(token[1]);
                    if (!((names[index].equals("Blacklisted") || names[index].equals("Lost")))) {
                        System.out.printf("%s was lost due to an error.%n", names[index]);
                        names[index] = "Lost";
                        lostNames++;
                    }
                    break;
                case "Change":
                    index = Integer.parseInt(token[1]);
                    String newName = token[2];
                    if (index >= 0 && index < names.length) {
                        if (!(names[index].equals("Blacklisted") && names[index].equals("Lost"))) {
                            System.out.printf("%s changed his username to %s.%n", names[index], newName);
                            names[index] = newName;
                        }
                    }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Blacklisted names: %d%n", blackListedCnt);
        System.out.printf("Lost names: %d%n", lostNames);
        System.out.println(String.join(" ", names));
    }
}





















