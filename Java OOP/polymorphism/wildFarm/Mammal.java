package polymorphism.wildFarm;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight,  String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public abstract void makeSound();

    @Override
    public abstract void eat(Food food);

    @Override
    public String toString() {
        return String.format(super.toString()+"%s, %d]",getLivingRegion(),getFoodEaten());
    }
}
