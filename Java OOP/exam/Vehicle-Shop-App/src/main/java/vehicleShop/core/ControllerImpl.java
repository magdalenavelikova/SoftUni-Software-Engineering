package vehicleShop.core;

import vehicleShop.models.shop.Shop;
import vehicleShop.models.shop.ShopImpl;
import vehicleShop.models.tool.Tool;
import vehicleShop.models.tool.ToolImpl;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.FirstShift;
import vehicleShop.models.worker.SecondShift;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.VehicleRepository;
import vehicleShop.repositories.WorkerRepository;

import java.util.List;
import java.util.stream.Collectors;


import static vehicleShop.common.ConstantMessages.*;
import static vehicleShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private WorkerRepository workerRepository;
    private VehicleRepository vehicleRepository;
    private int countMadeVehicle;

    public ControllerImpl() {
        this.workerRepository = new WorkerRepository();
        this.vehicleRepository = new VehicleRepository();
        this.countMadeVehicle = 0;
    }

    @Override
    public String addWorker(String type, String workerName) {

        Worker worker;
        if (type.equals("FirstShift")) {
            worker = new FirstShift(workerName);
        } else if (type.equals("SecondShift")) {
            worker = new SecondShift(workerName);
        } else {
            throw new IllegalArgumentException(WORKER_TYPE_DOESNT_EXIST);
        }
        workerRepository.add(worker);
        return String.format(ADDED_WORKER, type, workerName);

    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {
        Vehicle vehicle = new VehicleImpl(vehicleName, strengthRequired);
        vehicleRepository.add(vehicle);
        return String.format(SUCCESSFULLY_ADDED_VEHICLE, vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {
        Worker worker = workerRepository.findByName(workerName);
        if (worker == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }
        Tool tool = new ToolImpl(power);
        worker.addTool(tool);
        return String.format(SUCCESSFULLY_ADDED_TOOL_TO_WORKER, power, workerName);
    }

    @Override
    public String makingVehicle(String vehicleName) {
        List<Worker> workers = workerRepository.getWorkers().stream()
                .filter(w -> w.getStrength() > 70)
                .collect(Collectors.toList());

        if (workers.isEmpty()) {
            throw new IllegalArgumentException(NO_WORKER_READY);
        }

        Vehicle vehicle = vehicleRepository.findByName(vehicleName);

        Shop shop = new ShopImpl();
        long unshiftTools = 0;
        while (!workers.isEmpty() && !vehicle.reached()) {
            Worker worker = workers.get(0);
            shop.make(vehicle, worker);

            if (!worker.canWork() || worker.getTools().stream().noneMatch(t -> !t.isUnfit())) {
                unshiftTools += worker.getTools().stream().filter(Tool::isUnfit).count();
                workers.remove(worker);
                break;
            }
            unshiftTools += worker.getTools().stream().filter(Tool::isUnfit).count();
        }

        String infoAboutVehicle = "not done";
        if (vehicle.reached()) {
            infoAboutVehicle = "done";
            countMadeVehicle++;
        }
        StringBuilder output = new StringBuilder();
        output.append(String.format(VEHICLE_DONE, vehicleName, infoAboutVehicle));
        output.append(String.format(COUNT_BROKEN_INSTRUMENTS, unshiftTools));
        return output.toString().trim();
    }

    @Override
    public String statistics() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%d vehicles are ready!", countMadeVehicle)).append(System.lineSeparator());
        output.append("Info for workers:").append(System.lineSeparator());
        workerRepository.getWorkers().stream()
                .forEach(w -> output.append(w.toString()).append(System.lineSeparator()));
        return output.toString().trim();
    }
}
