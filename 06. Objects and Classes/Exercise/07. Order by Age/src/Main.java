import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            addPersonToList(personList, input);
            input = scanner.nextLine();
        }

        printSortedList(personList);
    }

    private static void printSortedList(List<Person> personList) {
        personList.stream()
                .sorted((p1, p2) -> p1.getAge() - p2.getAge())
                .forEach(System.out::println);
    }

    private static void addPersonToList(List<Person> personList, String input) {
        String[] tokens = input.split(" ");
        String name = tokens[0];
        String ID = tokens[1];
        int age = Integer.parseInt(tokens[2]);

        Person person = new Person(name, ID, age);
        personList.add(person);
    }
}



