public class Hero implements Comparable<Hero> {
    private String name;
    private int health;
    private int mana;

    public Hero(String name, int health, int mana) {
        this.name = name;
        setHealth(health);
        setMana(mana);
    }

    public String getName() {
        return name;
    }

    public Hero setName(String name) {
        this.name = name;
        return this;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.min(this.health + health, 100);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = Math.min(this.mana + mana, 200);
    }

    public void castSpell(int mana, String spellName) {
        if (this.mana >= mana) {
            this.mana -= mana;
            System.out.printf("%s has successfully cast %s and now has %d MP!\n", this.name, spellName, this.mana);
        } else {
            System.out.printf("%s does not have enough MP to cast %s!\n", this.name, spellName);
        }
    }

    public boolean takeDamage(int damage, String attacker) {
        this.health -= damage;

        if (this.health <= 0) {
            System.out.printf("%s has been killed by %s!\n", this.name, attacker);
            return true;
        }

        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n", this.name, damage, attacker, this.health);
        return false;
    }

    public void recharge(int mana) {
        if (mana + this.mana > 200) {
            int rechargedManaPoints = 200 - this.mana;
            System.out.printf("%s recharged for %d MP!\n", this.name, rechargedManaPoints);
            setMana(200);
        } else {
            System.out.printf("%s recharged for %d MP!\n", this.name, mana);
            setMana(mana);
        }
    }

    public void heal(int hp) {
        if (hp + this.health > 100) {
            int totalHealth = 100 - this.health;
            System.out.printf("%s healed for %d HP!\n", this.name, totalHealth);
            setHealth(100);
        } else {
            System.out.printf("%s healed for %d HP!\n", this.name, hp);
            setHealth(hp);
        }
    }

    @Override
    public int compareTo(Hero other) {
        int result = Integer.compare(other.getHealth(), this.health);
        if (result == 0) {
            result = this.name.compareTo(other.name);
        }
        return result;
    }
}
