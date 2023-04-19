package carShop;

public class Car {
    private String model;
    private int horsePower;
    private double price;

    public Car(String model, int horsePower, double price) {
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.setPrice(price);
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    public int getHorsePower() {
        return horsePower;
    }

    private void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
