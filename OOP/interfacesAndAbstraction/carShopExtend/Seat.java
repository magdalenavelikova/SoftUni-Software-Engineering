package interfacesAndAbstraction.carShopExtend;

public class Seat extends CarImpl implements Sellable {
    private Double price;

    public Seat(String model, String color, Integer horsePower, String country, Double price) {
        super(model, color, horsePower, country);
        this.price = price;
    }



    @Override
    public Double getPrice() {
        return this.price;
    }
    @Override
    public String toString() {
        return super.toString() + String.format("%n%s sells for $s", getModel(), getPrice());
    }
}
