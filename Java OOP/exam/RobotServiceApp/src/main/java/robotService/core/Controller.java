package robotService.core;

public interface Controller {
    String addService(String type, String name);
    String addSupplement(String type);
    String supplementForService(String serviceName, String supplementType);
    String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price);
    String feedingRobot(String serviceName);
    String sumOfAll(String serviceName);
    String getStatistics();
}
