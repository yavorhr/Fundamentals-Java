public class Truck {
    private String type;
    private String model;
    private String color;
    private int horsepower;

    public Truck(String model, String color, int horsepower) {
        this.type = "Truck";
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public String getModel() {
        return this.model;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    @Override
    public String toString() {
        return String.format("Type: %s%n" +
                "Model: %s%n" +
                "Color: %s%n" +
                "Horsepower: %d", this.type, this.model, this.color, this.horsepower);

    }
}
