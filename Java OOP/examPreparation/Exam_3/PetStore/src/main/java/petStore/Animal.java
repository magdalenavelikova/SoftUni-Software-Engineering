package petStore;

public class Animal {
    private String specie;
    private int age;
    private int maxKilograms;
    private double price;

    public Animal(String specie, int maxKilograms, double price) {
        this.setSpecie(specie);
        this.setMaxKilograms(maxKilograms);
        this.setPrice(price);
    }

    public String getSpecie() {
        return specie;
    }

    private void setSpecie(String specie) {
        this.specie = specie;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    public int getMaxKilograms() {
        return maxKilograms;
    }

    private void setMaxKilograms(int maxKilograms) {
        this.maxKilograms = maxKilograms;
    }
}
