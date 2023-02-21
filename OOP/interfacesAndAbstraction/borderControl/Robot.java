package interfacesAndAbstraction.borderControl;

public class Robot implements Identifiable{
    private String model;
    private String id;


    public Robot(String model,String id ) {
        this.model = model;
        this.id = id;

    }
    public  String getModel(){
    return model;
    }

    @Override
    public String getId() {
        return id;
    }
}
