package restaurant.entities.healthyFoods;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import static restaurant.common.ExceptionMessages.*;

public abstract class Food implements HealthyFood {
    private String name;
    private double portion;
    private double price;

    public Food(String name, double portion, double price) {
       setName(name);
       setPortion(portion);
      setPrice(price);
    }


    protected void setName(String name) {
        if (name.equals(null) || name.trim().isEmpty()) {
            throw new IllegalArgumentException (INVALID_NAME);
        }
        this.name=name;
    }

    protected void setPortion(double portion) {
        if (portion <=0) {
            throw new IllegalArgumentException(INVALID_PORTION );
        }
        this.portion = portion;
    }

    protected void setPrice(double price) {
        if (price <=0) {
            throw new IllegalArgumentException(INVALID_PRICE );
        }

        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPortion() {
        return this.portion;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
