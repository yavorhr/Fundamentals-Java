import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] gifts = scanner.nextLine().split(" ");

        String input = scanner.nextLine();
        while (!"No Money".equals(input)) {
            String command = input.split(" ")[0];
            String gift = input.split(" ")[1];
            int index = getIndex(gifts, gift);

            switch (command) {
                case "OutOfStock" -> {
                    while (index != -1) {
                        gifts[index] = "None";
                        index = getIndex(gifts, gift);
                    }
                }
                case "Required" -> {
                    if (index != -1) {
                        gifts[index] = gift;
                    }
                }
                case "JustInCase" -> gifts[gifts.length - 1] = gift;
            }
            input = scanner.nextLine();
        }
        printResult(gifts);
    }

    private static void printResult(String[] gifts) {
        Arrays
                .stream(gifts)
                .filter(g -> !g.equals("None"))
                .forEach(g -> System.out.print(g + " "));
    }

    private static int getIndex(String[] gifts, String gift) {
        return Arrays
                .asList(gifts)
                .indexOf(gift);
    }
}


