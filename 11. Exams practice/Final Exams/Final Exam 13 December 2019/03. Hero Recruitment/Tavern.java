import java.util.HashMap;
import java.util.Map;

public class Tavern {
    private Map<String, Hero> heroes;

    public Tavern() {
        this.heroes = new HashMap<>();
    }

    public void enroll(Hero hero) {
        this.heroes.put(hero.getName(), hero);
    }

    public boolean heroExists(String name) {
        Hero hero = findHero(name);
        return hero != null;
    }

    public Hero findHero(String name) {
        return this.heroes.get(name);
    }

    public void updateTavern(Hero hero) {
        this.heroes.put(hero.getName(), hero);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Heroes:\n");

        this.heroes
                .values()
                .forEach(h -> sb.append(h.toString()));

        return sb.toString();
    }
}
