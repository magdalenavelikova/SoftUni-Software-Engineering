package workingWithAbstraction.hotelReservation;

public class PriceCalculator {
    //price per day, number of days, the season, and a discount type.
    private double pricePerDay;
    private int numbersOfDays;
    Season season;
    Discount discount;

    public PriceCalculator(double pricePerDay, int numbersOfDays, Season season, Discount discount) {
        this.pricePerDay = pricePerDay;
        this.numbersOfDays = numbersOfDays;
        this.season = season;
        this.discount = discount;
    }

    public double getPricePerHoliday() {
        return pricePerDay * numbersOfDays * season.getMultiplier() * discount.getPriceReducer();
    }
}
