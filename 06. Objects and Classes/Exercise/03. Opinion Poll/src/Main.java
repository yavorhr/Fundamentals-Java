import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person person;
        List<Person> personList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            person = new Person(input[0], Integer.parseInt(input[1]));

            if (person.age > 30) {
                personList.add(person);
            }
        }

        Collections.sort(personList);
        personList.forEach(p -> System.out.printf("%s - %d%n", p.name, p.age));
    }
}






