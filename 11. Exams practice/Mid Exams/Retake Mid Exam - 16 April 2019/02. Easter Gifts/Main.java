import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] gifts = scanner.nextLine().split("\\s+");

        String input = scanner.nextLine();
        while (!"No Money".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String gift = tokens[1];

            switch (command) {
                case "OutOfStock":
                    for (int i = 0; i < gifts.length; i++) {
                        if (gifts[i].equals(gift)) {
                            gifts[i] = "None";
                        }
                    }
                    break;
                case "Required":
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < gifts.length) {
                        gifts[index] = gift;
                    }
                    break;
                case "JustInCase":
                    gifts[gifts.length - 1] = gift;
                    break;
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < gifts.length; i++) {
            if (gifts[i] != "None") {
                System.out.print(gifts[i] + " ");
            }
        }

    }
}





































