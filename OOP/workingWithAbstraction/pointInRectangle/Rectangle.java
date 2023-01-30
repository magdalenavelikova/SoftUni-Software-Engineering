package workingWithAbstraction.pointInRectangle;

public class Rectangle {
    private Point A;
    private Point C;

    public Rectangle(Point A, Point C) {
        this.A = A;
        this.C = C;
    }

    public boolean contains(Point x) {
        return x.isGreaterOrEqual(A) && x.isLessOrEqual(C);

    }
}
