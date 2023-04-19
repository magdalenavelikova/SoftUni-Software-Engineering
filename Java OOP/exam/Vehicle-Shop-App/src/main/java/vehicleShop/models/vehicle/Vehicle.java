package vehicleShop.models.vehicle;

public interface Vehicle {
    String getName();

    int getStrengthRequired();

    boolean reached();

    void making();
}
