package polymorphism.wildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime{
    private String breed;
    public Cat(String animalName, String animalType, Double animalWeight,  String livingRegion, String breed) {
        super(animalName, animalType, animalWeight,  livingRegion);
        this.breed=breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
       setFoodEaten(getFoodEaten()+ food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat df=new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]",getAnimalType(),getAnimalName(),getBreed(),df.format(getAnimalWeight()),getLivingRegion(),getFoodEaten());
    }
}
