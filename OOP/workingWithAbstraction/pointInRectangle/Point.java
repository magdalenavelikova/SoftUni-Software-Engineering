package workingWithAbstraction.pointInRectangle;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isGreaterOrEqual(Point other) {
        return x >= other.x && y >= other.y;
    }

    public boolean isLessOrEqual(Point other) {
        return x <= other.x && y <= other.y;
    }
}
