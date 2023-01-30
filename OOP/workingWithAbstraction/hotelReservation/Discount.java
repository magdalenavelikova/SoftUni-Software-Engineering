package workingWithAbstraction.hotelReservation;

public enum Discount {

    VIP(0.8),
    SECOND_VISIT(0.9),
    NONE(1);

    private double priceReducer;

    Discount(double priceReducer) {
        this.priceReducer = priceReducer;
    }

    public static Discount parse(String s) {
        switch (s){
            case "VIP":
                return Discount.valueOf(s);
            case "SecondVisit":
                return Discount.valueOf("SECOND_VISIT");
            case "None":
                return Discount.valueOf(s.toUpperCase());
            default:
                throw new IllegalArgumentException("Unknown type of Discount!");

        }

    }

    public double getPriceReducer() {
        return this.priceReducer;
    }
}
