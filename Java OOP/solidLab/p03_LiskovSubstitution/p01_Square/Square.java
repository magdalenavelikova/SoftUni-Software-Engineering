package solidLab.p03_LiskovSubstitution.p01_Square;

public class Square implements Shape {
private double side;
    public Square(double side) {
        this.side=side;
    }


    @Override
    public double getArea() {
        return side*side;
    }
}
