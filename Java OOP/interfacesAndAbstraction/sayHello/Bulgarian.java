package interfacesAndAbstraction.sayHello;

public class Bulgarian implements Person {
    private String  name;

    public Bulgarian(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
