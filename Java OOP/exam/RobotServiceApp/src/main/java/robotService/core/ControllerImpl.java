package robotService.core;

import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;


import static robotService.common.ConstantMessages.*;
import static robotService.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private SupplementRepository supplements;
    private Collection<Service> services;


    public ControllerImpl() {
        supplements = new SupplementRepository();
        services = new ArrayList<>();
    }

    @Override
    public String addService(String type, String name) {
        Service service;
        if (type.equals("MainService")) {
            service = new MainService(name);
        } else if (type.equals("SecondaryService")) {
            service = new SecondaryService(name);
        } else {
            throw new NullPointerException(INVALID_SERVICE_TYPE);
        }

        services.add(service);
        return String.format(SUCCESSFULLY_ADDED_SERVICE_TYPE, type);

    }

    @Override
    public String addSupplement(String type) {
        Supplement supplement;
        if (type.equals("MetalArmor")) {
            supplement = new MetalArmor();
        } else if (type.equals("PlasticArmor")) {
            supplement = new PlasticArmor();
        } else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        supplements.addSupplement(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Service service = getService(serviceName);
        Supplement supplement = supplements.findFirst(supplementType);
        if (supplement == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }
        service.addSupplement(supplement);
        supplements.removeSupplement(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
    }


    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Robot robot;
        if (robotType.equals("FemaleRobot")) {
            robot = new FemaleRobot(robotName, robotKind, price);
        } else if (robotType.equals("MaleRobot")) {
            robot = new MaleRobot(robotName, robotKind, price);
        } else {
            throw new IllegalArgumentException(INVALID_ROBOT_TYPE);
        }
        Service service = getService(serviceName);

        if ((robotType.equals("MaleRobot") && service.getClass().getSimpleName().equals("SecondaryService")) ||
                (robotType.equals("FemaleRobot") && service.getClass().getSimpleName().equals("MainService"))) {
            return UNSUITABLE_SERVICE;
        }
        service.addRobot(robot);
        return String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
    }

    @Override
    public String feedingRobot(String serviceName) {
        Service service = getService(serviceName);
        service.getRobots().stream().forEach(r -> r.eating());
        int robotsCount = service.getRobots().size();
        return String.format(FEEDING_ROBOT, robotsCount);
    }

    @Override
    public String sumOfAll(String serviceName) {
        Service service = getService(serviceName);
        double sumOfRobotsPrice = service.getRobots().stream().mapToDouble(Robot::getPrice).sum();
        double sumOfSupplementsPrice = service.getSupplements().stream().mapToDouble(Supplement::getPrice).sum();
        return String.format(VALUE_SERVICE, serviceName, sumOfRobotsPrice + sumOfSupplementsPrice);
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        services.forEach(s -> output.append(s.getStatistics()).append(System.lineSeparator()));
        return output.toString().trim();
    }

    private Service getService(String serviceName) {
        return services.stream().filter(s -> s.getName().equals(serviceName)).findFirst().orElse(null);
    }
}
