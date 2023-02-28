package solidLab.p03_LiskovSubstitution.p01_Square;

public class Rectangle implements Shape {
   private double width;

   private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }



    @Override
    public double getArea() {
       return this.width*this.height;
    }
}
