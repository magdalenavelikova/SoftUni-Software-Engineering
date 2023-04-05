package catHouse.core;

public interface Controller {

    String addHouse(String type, String name);

    String buyToy(String type);

    String toyForHouse(String houseName, String toyType);

    String addCat(String houseName, String catType, String catName, String catBreed, double price);

    String feedingCat(String houseName);

    String sumOfAll(String houseName);

    String getStatistics();
}
