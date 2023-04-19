package vehicleShop.models.worker;

public class SecondShift extends BaseWorker {
    private static final int STRENGTH = 70;

    public SecondShift(String name) {
        super(name, STRENGTH);
    }

    @Override
    public void working() {
        super.setStrength(Math.max(super.getStrength() - 5, 0));
    }
}
