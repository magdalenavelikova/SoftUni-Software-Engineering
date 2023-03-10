package designPattern.factoryPattern;

public class CakeFactory {
    public static Cake createCake(String cakeType, double diameter, double price, int pieces) {
        switch (cakeType) {
            case "ChocolateCake":
                return new ChocolateCake(diameter, price, pieces);
            case "SpinachCake":
                return new SpinachCake(diameter, price, pieces);
            default:
                return null;
        }
    }
}
