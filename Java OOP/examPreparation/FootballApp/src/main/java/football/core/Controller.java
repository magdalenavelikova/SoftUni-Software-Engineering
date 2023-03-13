package football.core;

public interface Controller {
    String addField(String fieldType, String fieldName);
    String deliverySupplement(String type);
    String supplementForField(String fieldName, String supplementType);
    String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength);
    String dragPlayer(String fieldName);
    String calculateStrength(String fieldName);
    String getStatistics();
}
