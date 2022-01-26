public class Vehicle {
    private String typeOfVehicle;
    private String model;
    private String color;
    private double horsepower;

    public Vehicle(String typeOfVehicle, String model, String color, double horsepower) {
        this.typeOfVehicle = typeOfVehicle;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public String getModel() {
        return this.model;
    }

    public double getHorsepower() {
        return this.horsepower;
    }

    public String getTypeOfVehicle() {
        return this.typeOfVehicle;
    }

    @Override
    public String toString() {
        String typeOfVehicleUpper = "";
        if ("car".equalsIgnoreCase(this.typeOfVehicle)) {
            typeOfVehicleUpper = "Car";
        } else if ("truck".equalsIgnoreCase(this.typeOfVehicle)) {
            typeOfVehicleUpper = "Truck";
        }
        String output = String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %.0f",
                typeOfVehicleUpper, this.model, this.color, this.horsepower);
        return output;
    }
}