package workingWithAbstraction.hotelReservation;



public enum Season {

 AUTUMN(1),
 SPRING(2),
 WINTER(3),
 SUMMER(4);
 private int multiplier;

    Season(int multiplier) {
        this.multiplier = multiplier;
    }

    public static Season parse(String str) {
      return Season.valueOf(str.toUpperCase());
    }

    public int getMultiplier() {
        return multiplier;
    }
}
