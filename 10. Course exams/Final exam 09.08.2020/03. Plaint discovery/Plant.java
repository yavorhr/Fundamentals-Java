public class Plant implements Comparable<Plant> {
    private String name;
    private int rarity;
    private double rating;
    private int ratingsCount = 0;

    public Plant(String name, int rarity) {
        this.name = name;
        this.rarity = rarity;
        this.rating = 0;
    }

    public void rate(int rating) {
        this.rating += rating;
        ratingsCount++;
    }

    public void updateRarity(int rarity) {
        this.rarity = rarity;
    }

    public void resetRating() {
        this.rating = 0;
    }

    public double getAvgRating() {
        return this.rating / this.ratingsCount;
    }

    public int getRarity() {
        return rarity;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("- %s; Rarity: %d; Rating: %.2f", this.name, this.rarity, getAvgRating());
    }

    @Override
    public int compareTo(Plant otherPlant) {
        int result = otherPlant.getRarity() - this.rarity;
        if (result == 0) {
            result = Double.compare(otherPlant.getAvgRating(), this.getAvgRating());
        }
        return result;
    }
}
