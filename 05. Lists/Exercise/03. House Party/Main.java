import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> partyList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            String goingOrNot = tokens[2];

            modifyPartyList(name, goingOrNot, partyList);

        }
        printResult(partyList);
    }

    private static void modifyPartyList(String name, String goingOrNot, List<String> list) {
        switch (goingOrNot) {
            case "going!" -> {
                boolean alreadyInvited = list.contains(name);

                if (alreadyInvited) {
                    System.out.printf("%s is already in the list!\n", name);
                } else {
                    list.add(name);
                }
            }
            case "not" -> {
                boolean cancelInvitation = list.contains(name);
                if (cancelInvitation) {
                    list.remove(name);
                } else {
                    System.out.printf("%s is not in the list!\n", name);
                }
            }
        }
    }

    private static void printResult(List<String> partyList) {
        for (String name : partyList) {
            System.out.println(name);
        }
    }
}