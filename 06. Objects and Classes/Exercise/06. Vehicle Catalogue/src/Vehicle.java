public class Vehicle {
    private String typeOfVehicle;
    private String model;
    private String color;
    private double horsePower;

    public Vehicle(String typeOfVehicle, String model, String color, double horsePower) {
        this.typeOfVehicle = typeOfVehicle;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public Vehicle setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Vehicle setModel(String model) {
        this.model = model;
        return this;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public Vehicle setHorsePower(int horsePower) {
        this.horsePower = horsePower;
        return this;
    }

    @Override
    public String toString() {
        String typeOfVehicle = "";

        if ("car".equalsIgnoreCase(this.typeOfVehicle)) {
            typeOfVehicle = "Car";
        } else if ("truck".equalsIgnoreCase(this.typeOfVehicle)) {
            typeOfVehicle = "Truck";
        }
        return String.format("Type: %s\n" +
                "Model: %s\n" +
                "Color: %s\n" +
                "Horsepower: %.0f", typeOfVehicle,this.getModel(),this.getColor(),this.getHorsePower() );
    }
}
