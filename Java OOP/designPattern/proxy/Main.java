package designPattern.proxy;

public class Main {
    public static void main(String[] args) {
        Animal dog=new DogProxy();
        dog.speak();
    }
}
