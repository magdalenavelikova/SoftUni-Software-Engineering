package inheritanceExercise.animals;

public class Kitten extends Cat {
    public static final String DEFAULT_GENDER = "Female";

    public Kitten(String name, int age) {
        super(name, age, DEFAULT_GENDER);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }

}
