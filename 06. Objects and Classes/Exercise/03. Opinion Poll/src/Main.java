import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        addPersonsToList(scanner, personList, n);
        printPersonsOver30SortedAlph(personList);
    }

    private static void printPersonsOver30SortedAlph(List<Person> personList) {
        personList.stream()
                .sorted((p1,p2) -> p1.getName().compareTo(p2.getName()))
                .filter(p -> p.getAge() > 30)
                .forEach(System.out::println);
    }

    private static void addPersonsToList(Scanner scanner, List<Person> personList, int n) {
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            personList.add(person);
        }
    }
}


