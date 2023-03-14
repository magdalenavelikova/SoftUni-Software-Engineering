package zoo.core;

import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.LinkedHashMap;
import java.util.Map;

import static zoo.common.ConstantMessages.*;
import static zoo.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository foodRepository;
    private Map<String, Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new LinkedHashMap<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        Area area;
        if (areaType.equals("WaterArea")) {
            area = new WaterArea(areaName);
        } else if (areaType.equals("LandArea")) {
            area = new LandArea(areaName);
        } else {
            throw new NullPointerException(INVALID_AREA_TYPE);
        }
        areas.put(areaName, area);
        return String.format(SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        Food food;
        if (foodType.equals("Vegetable")) {
            food = new Vegetable();
        } else if (foodType.equals("Meat")) {
            food = new Meat();
        } else {
            throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }
        foodRepository.add(food);
        return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food foodByType = foodRepository.findByType(foodType);

        if (foodByType == null) {
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType));
        }

        areas.get(areaName).addFood(foodByType);
        foodRepository.remove(foodByType);
        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        String output;
        Animal animal;
        if (animalType.equals("AquaticAnimal")) {
            animal = new AquaticAnimal(animalName, kind, price);
        } else if (animalType.equals("TerrestrialAnimal")) {
            animal = new TerrestrialAnimal(animalName, kind, price);
        } else {
            throw new IllegalArgumentException(String.format(INVALID_ANIMAL_TYPE, animalType));
        }
        String areaType = areas.get(areaName).getClass().getSimpleName();
        if (isValidArea(animal, areaType)) {
            areas.get(areaName).addAnimal(animal);
            output = String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
        } else {
            output = AREA_NOT_SUITABLE;
        }
        return output;
    }


    @Override
    public String feedAnimal(String areaName) {
        areas.get(areaName).feed();

        return String.format(ANIMALS_FED,areas.get(areaName).getAnimals().size());
    }

    @Override
    public String calculateKg(String areaName) {
        double sum = areas.get(areaName).getAnimals().stream().mapToDouble(a -> a.getKg()).sum();
        return String.format(KILOGRAMS_AREA,areaName,sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder output=new StringBuilder();
        for (Area a : areas.values()) {
            output.append(a.getInfo()).append(System.lineSeparator());
        }
        return output.toString().trim();
    }
    private boolean isValidArea(Animal animal, String areaType) {

        return ((animal.getClass().getSimpleName().equals("AquaticAnimal") && areaType.equals("WaterArea")) ||
                (animal.getClass().getSimpleName().equals("TerrestrialAnimal") && areaType.equals("LandArea")));
    }
}
