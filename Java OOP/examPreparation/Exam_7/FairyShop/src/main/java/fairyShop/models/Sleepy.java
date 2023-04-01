package fairyShop.models;

public class Sleepy extends BaseHelper{
    private final static int ENERGY=50;
    public Sleepy(String name) {
        super(name, ENERGY);
    }

    @Override
    public void work() {
        if (super.getEnergy() - 15 < 0) {
            super.setEnergy(0);
        } else {
            super.setEnergy(super.getEnergy()-15);
        }

    }
}
