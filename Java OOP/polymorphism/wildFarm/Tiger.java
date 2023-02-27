package polymorphism.wildFarm;

public class Tiger extends Felime{
private String livingRegion;
    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight,  livingRegion);
    }
    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }
    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            setFoodEaten(food.getQuantity()+getFoodEaten());
        } else {
            setFoodEaten(0+getFoodEaten());
            System.out.printf("%ss are not eating that type of food!%n", getAnimalType());
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
