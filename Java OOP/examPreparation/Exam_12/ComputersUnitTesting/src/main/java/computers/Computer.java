package computers;

public class Computer {

    private String manufacturer;
    private String model;
    private double price;

    public Computer(String manufacturer, String model, double price) {
        this.setManufacturer(manufacturer);
        this.setModel(model);
        this.setPrice(price);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    private void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
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
}
