package vehicleShop.models.shop;

import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.worker.Worker;

public interface Shop {
    void make(Vehicle vehicle, Worker worker);
}
