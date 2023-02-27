package polymorphism.wildFarm;

public class Mouse extends Mammal {
    public Mouse(String animalName, String animalType, Double animalWeight,  String livingRegion) {
        super(animalName, animalType, animalWeight,  livingRegion);
    }


    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            setFoodEaten(food.getQuantity()+getFoodEaten());
        } else {
            setFoodEaten(0+getFoodEaten());
            System.out.println("Mice are not eating that type of food!");
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
