import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String charityAmount = scanner.nextLine();

        String input = scanner.nextLine();
        while (!"Finish".equals(input)) {
            String[] parts = input.split(" ");
            String command = parts[0];

            switch (command) {
                case "Replace":
                    String currentChar = parts[1];
                    String newChar = parts[2];

                    charityAmount = charityAmount.replace(currentChar, newChar);
                    System.out.println(charityAmount);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(parts[1]);
                    int endIndex = Integer.parseInt(parts[2]);

                    if (startIndex >= 0 && endIndex < charityAmount.length()) {
                        String substring = charityAmount.substring(startIndex, endIndex + 1);
                        charityAmount = charityAmount.replace(substring, "");
                        System.out.println(charityAmount);
                    } else {
                        System.out.println("Invalid indexes!");
                    }
                    break;
                case "Make":
                    String upperOrLower = parts[1];
                    if (upperOrLower.equals("Upper")) {
                        charityAmount = charityAmount.toUpperCase();
                        System.out.println(charityAmount);
                    } else if (upperOrLower.equals("Lower")) {
                        charityAmount = charityAmount.toLowerCase();
                        System.out.println(charityAmount);
                    }
                    break;
                case "Check":
                    String string = parts[1];
                    if (charityAmount.contains(string)) {
                        System.out.println(String.format("Message contains %s", string));
                    } else {
                        System.out.println(String.format("Message doesn't contain %s", string));
                    }
                    break;
                case "Sum":
                    startIndex = Integer.parseInt(parts[1]);
                    endIndex = Integer.parseInt(parts[2]);
                    if (startIndex >= 0 && endIndex < charityAmount.length()) {
                        int sum = 0;
                        String substring = charityAmount.substring(startIndex, endIndex+ 1);
                        for (int i = 0; i < substring.length(); i++) {
                            int currChar = substring.charAt(i);
                            sum += currChar;
                        }
                        System.out.println(sum);
                    } else {
                        System.out.println("Invalid indexes!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}




