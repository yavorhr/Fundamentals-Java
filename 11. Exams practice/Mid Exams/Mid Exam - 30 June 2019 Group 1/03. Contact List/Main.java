import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> contactsBook = Arrays.stream(scanner.nextLine()
                .split(" "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (true) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            if (command.equals("Print")) {
                String condition = tokens[1];

                if (condition.equals("Normal")) {
                    printContacts(contactsBook);
                } else if (condition.equals("Reversed")) {
                    Collections.reverse(contactsBook);
                    printContacts(contactsBook);
                    break;
                }
            } else {
                switch (command) {
                    case "Add" -> {
                        String contact = tokens[1];
                        int index = Integer.parseInt(tokens[2]);

                        if (isContains(contactsBook, contact)) {
                            contactsBook.add(index, contact);
                        } else {
                            contactsBook.add(contact);
                        }
                    }
                    case "Remove" -> {
                        int index = Integer.parseInt(tokens[1]);
                        if (isIndexValid(contactsBook, index)) {
                            contactsBook.remove(index);
                        }
                    }
                    case "Export" -> {
                        int startIndex = Integer.parseInt(tokens[1]);
                        int count = Integer.parseInt(tokens[2]);

                        if (count > contactsBook.size()) {
                            count = contactsBook.size();
                        }

                        printContactsByGivenLength(contactsBook, startIndex, count);
                        System.out.println();
                    }
                }
            }
            input = scanner.nextLine();
        }
    }

    private static void printContacts(List<String> contactsBook) {
        System.out.println("Contacts: " + contactsBook.toString().replaceAll("[\\[\\]]", ""));
    }

    private static void printContactsByGivenLength(List<String> contactsBook, int startIndex, int count) {
        for (int i = startIndex; i < count; i++) {
            System.out.print(contactsBook.get(i) + " ");
        }
    }

    private static boolean isIndexValid(List<String> contactsBook, int index) {
        return index >= 0 && index < contactsBook.size();
    }

    private static boolean isContains(List<String> contactsBook, String contact) {
        return contactsBook.contains(contact);
    }
}




