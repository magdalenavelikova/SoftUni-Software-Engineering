package vehicleShop.models.shop;

import vehicleShop.models.tool.Tool;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.worker.Worker;

import java.util.Collection;

public class ShopImpl implements Shop {

    @Override
    public void make(Vehicle vehicle, Worker worker) {
        Collection<Tool> tools = worker.getTools();
        while (worker.canWork() && !vehicle.reached() && tools.iterator().hasNext()) {
            Tool currentTool = tools.iterator().next();
            currentTool.decreasesPower();
            worker.working();
            vehicle.making();
            if (currentTool.isUnfit()) {
                currentTool = tools.iterator().next();
            }
        }

    }
}
