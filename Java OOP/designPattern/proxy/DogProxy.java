package designPattern.proxy;

public class DogProxy implements Animal {
    private Dog dog;

    public DogProxy() {
        this.dog = new Dog();
    }

    @Override
    public void speak() {
        before();
        dog.speak();
        after();
    }

    public void before() {
        System.out.println("Before");
    }

    public void after() {
        System.out.println("After");
    }
}
