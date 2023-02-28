package solidLab.p03_LiskovSubstitution.p01_Square;

public class Main {
    public static void main(String[] args) {
        Shape rectangle=new Rectangle(10,3);
        Shape square=new Square(10) ;
        printArea(rectangle);
        printArea(square);
    }

    private static void printArea(Shape shape) {
        System.out.println(shape.getArea());
    }
}
