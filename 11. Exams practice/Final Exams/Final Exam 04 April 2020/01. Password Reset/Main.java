import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        String input = scanner.nextLine();
        while (!"Done".equals(input)) {
            String[] parts = input.split(" ");
            String command = parts[0];
            StringBuilder sb = new StringBuilder();

            switch (command) {
                case "TakeOdd":
                    for (int i = 0; i < password.length(); i++) {
                        if (i % 2 != 0) {
                            sb.append(password.charAt(i));
                        }
                    }
                    password = String.valueOf(sb);
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(parts[1]);
                    int еndIndex = Integer.parseInt(parts[2]) + index;

                    sb.append(password).delete(index, еndIndex);
                    password = String.valueOf(sb);
                    System.out.println(password);

                    break;
                case "Substitute":
                    String toFind = parts[1];
                    String toReplace = parts[2];

                    if (password.contains(toFind)) {
                        password = password.replace(toFind, toReplace);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.format("Your password is: %s", password));
    }
}
