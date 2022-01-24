import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersInLine = scanner.nextLine().split(" ");
        List<Integer> pokemonDistance = new ArrayList<>();

        for (String number : numbersInLine) {
            int currentPokemon = Integer.parseInt(number);
            pokemonDistance.add(currentPokemon);
        }

        int valueOfRemovedElements = 0;

        while (!pokemonDistance.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());
            int indexToRemove = 0;
            if (index < 0) {
                indexToRemove = pokemonDistance.remove(0);
                valueOfRemovedElements += indexToRemove;
                pokemonDistance.add(0, pokemonDistance.get(pokemonDistance.size() - 1));
            } else if (index > pokemonDistance.size() - 1) {
                indexToRemove = pokemonDistance.remove(pokemonDistance.size() - 1);
                pokemonDistance.add(pokemonDistance.get(0));
                valueOfRemovedElements += indexToRemove;
            } else {
                indexToRemove = pokemonDistance.remove(index);
                valueOfRemovedElements += indexToRemove;
            }

            for (int i = 0; i < pokemonDistance.size(); i++) {
                if (pokemonDistance.get(i) <= indexToRemove) {
                    pokemonDistance.set(i, pokemonDistance.get(i) + indexToRemove);
                } else {
                    pokemonDistance.set(i, pokemonDistance.get(i) - indexToRemove);
                }
            }
        }

        System.out.println(valueOfRemovedElements);
    }
}





