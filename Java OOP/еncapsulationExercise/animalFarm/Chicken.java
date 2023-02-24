package еncapsulationExercise.animalFarm;

public class Chicken {
    private String name;
    private int age;

    private double calculateProductPerDay() {
        if (this.age >= 0 && this.age < 6) {
            return 2;
        } else if (this.age >= 6 && this.age <= 11) {
            return 1;
        }
        return 0.75;
    }

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if (name==null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) ",this.name,this.age);
    }
}
