import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pokemonDistance =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        int valueOfRemovedElements = 0;

        while (!pokemonDistance.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());
            int removedElementValue = 0;
            int lastIndex = pokemonDistance.size() - 1;

            if (index < 0) {
                removedElementValue = getRemovedElementValue(pokemonDistance, 0);
                pokemonDistance.add(0, pokemonDistance.get(lastIndex));
                valueOfRemovedElements += removedElementValue;
            } else if (index > lastIndex) {
                removedElementValue = getRemovedElementValue(pokemonDistance, lastIndex);
                pokemonDistance.add(pokemonDistance.get(0));
                valueOfRemovedElements += removedElementValue;
            } else {
                removedElementValue = getRemovedElementValue(pokemonDistance, index);
                valueOfRemovedElements += removedElementValue;
            }

            for (int i = 0; i < pokemonDistance.size(); i++) {
                if (pokemonDistance.get(i) <= removedElementValue) {
                    pokemonDistance.set(i, pokemonDistance.get(i) + removedElementValue);
                } else {
                    pokemonDistance.set(i, pokemonDistance.get(i) - removedElementValue);
                }
            }
        }
        System.out.println(valueOfRemovedElements);
    }

    private static int getRemovedElementValue(List<Integer> pokemonDistance, int i2) {
        int removedElementValue;
        removedElementValue = pokemonDistance.remove(i2);
        return removedElementValue;
    }
}

