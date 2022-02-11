import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("\\s+");
        List<String> contactsList = new ArrayList<>();
        contactsList.addAll(Arrays.asList(text));


        while (true) {
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");
            String command = tokens[0];
            String name = tokens[1];

            if (command.equals("Print")) {
                String printType = tokens[1];
                if (printType.equals("Reversed")) {
                    Collections.reverse(contactsList);
                    System.out.print("Contacts: ");
                    System.out.println(String.join(" ", contactsList));
                    break;
                } else if (printType.equals("Normal")) {
                    System.out.print("Contacts: ");
                    System.out.println(String.join(" ", contactsList));
                    break;
                }
            }

            switch (command) {
                case "Add":
                    int index = Integer.parseInt(tokens[2]);
                    if (!contactsList.contains(name)) {
                        contactsList.add(name);
                    } else if (contactsList.contains(name) && index >= 0 && index <= contactsList.size() - 1) {
                        contactsList.add(index, name);
                    }
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(tokens[1]);
                    if (indexToRemove >= 0 && indexToRemove <= contactsList.size() - 1) {
                        contactsList.remove(indexToRemove);
                    }
                    break;
                case "Export":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int count = Integer.parseInt(tokens[2]);

                    if (startIndex + count < contactsList.size()) {
                        for (int i = startIndex; i < count + startIndex; i++) {
                            System.out.print(contactsList.get(i) + " ");
                        }
                        System.out.println();
                        break;
                    } else if (count > contactsList.size() - 1) {
                        for (int i = startIndex; i < contactsList.size(); i++) {
                            System.out.print(contactsList.get(i) + " ");
                        }
                    }
                    System.out.println();
                    break;
            }
        }

    }
}

































