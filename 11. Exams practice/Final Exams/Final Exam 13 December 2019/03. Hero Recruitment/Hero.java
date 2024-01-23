import java.util.ArrayList;
import java.util.List;

public class Hero implements Comparable<Hero> {
    private String name;
    private List<String> spellBook;

    public Hero(String name) {
        this.name = name;
        this.spellBook = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getSpellBookSize() {
        return this.spellBook.size();
    }

    public void learn(String spellName) {
        if (this.spellBook.contains(spellName)) {
            System.out.printf("%s has already learnt %s.\n", this.name, spellName);
        } else {
            this.spellBook.add(spellName);
        }
    }

    public void unlearn(String spellName) {
        if (!this.spellBook.contains(spellName)) {
            System.out.printf("%s doesn't know %s.\n", this.name, spellName);
        } else {
            this.spellBook.remove(spellName);
        }
    }

    @Override
    public int compareTo(Hero otherHero) {
        int result = Integer.compare(otherHero.getSpellBookSize(), this.getSpellBookSize());
        if (result == 0) {
            result = this.name.compareTo(otherHero.getName());
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("== %s: %s\n", this.name, getSpells(this.spellBook));
    }

    private String getSpells(List<String> spellBook) {
        return String.join(", ", spellBook);
    }
}
