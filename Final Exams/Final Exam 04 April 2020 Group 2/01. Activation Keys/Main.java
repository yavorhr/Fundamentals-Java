import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rawActivationKey = scanner.nextLine();

        String input = scanner.nextLine();
        while (!"Generate".equals(input)) {


            String[] parts = input.split(">>>");
            String command = parts[0];

            switch (command) {
                case "Contains":
                    String toFind = parts[1];
                    if (rawActivationKey.contains(toFind)) {
                        System.out.println(String.format("%s contains %s", rawActivationKey, toFind));
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upperOrLower = parts[1];
                    int startIndex = Integer.parseInt(parts[2]);
                    int endIndex = Integer.parseInt(parts[3]);
                    String substring = rawActivationKey.substring(startIndex, endIndex);

                    if (upperOrLower.equals("Upper")) {
                        String temp = substring.toUpperCase();
                        rawActivationKey = rawActivationKey.replace(substring, temp);
                        System.out.println(rawActivationKey);
                    } else {
                        String temp = substring.toLowerCase();
                        rawActivationKey = rawActivationKey.replace(substring, temp);
                        System.out.println(rawActivationKey);
                    }
                    break;
                case "Slice":
                    startIndex = Integer.parseInt(parts[1]);
                    endIndex = Integer.parseInt(parts[2]);
                    String toReplace = rawActivationKey.substring(startIndex, endIndex);
                    rawActivationKey = rawActivationKey.replace(toReplace, "");
                    System.out.println(rawActivationKey);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.format("Your activation key is: %s",rawActivationKey));
    }
}

