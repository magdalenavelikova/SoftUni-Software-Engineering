package designPattern.proxy;

public class Dog implements Animal{
    public void bark(){
        System.out.println("Bark bark");
    }

    @Override
    public void speak() {
        System.out.println("Hi");
    }
}
