package vehicleShop.models.tool;

import static vehicleShop.common.ExceptionMessages.TOOL_POWER_LESS_THAN_ZERO;

public class ToolImpl implements Tool{

    private int	power;

    public ToolImpl(int power) {
        setPower(power);
    }

    protected void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(TOOL_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void decreasesPower() {
        setPower(Math.max(getPower() - 5, 0));
    }

    @Override
    public boolean isUnfit() {
        return getPower()==0;
    }
}
