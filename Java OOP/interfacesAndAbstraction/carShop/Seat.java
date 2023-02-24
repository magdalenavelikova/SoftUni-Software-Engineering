package interfacesAndAbstraction.carShop;

public class Seat implements Car {

    private  String model;
    private  String color;
    private  Integer horsePower;
    private  String country;

    public Seat(String model, String color, Integer horsePower, String country) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires",model,country,TIRES);
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Integer getHorsePower() {
        return horsePower;
    }

    @Override
    public String countryProduced() {
        return country;
    }
}
