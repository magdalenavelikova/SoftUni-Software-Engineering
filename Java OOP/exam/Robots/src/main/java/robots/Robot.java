package robots;

public class Robot {
    private String name;
    private boolean isReadyForSale;

    public Robot(String name){
        this.setName(name);
        this.setReadyForSale(true);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public boolean isReadyForSale() {
        return isReadyForSale;
    }

    public void setReadyForSale(boolean readyForSale) {
        this.isReadyForSale = readyForSale;
    }
}
