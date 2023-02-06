package еncapsulationExercise.box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    //should not be zero or a negative number
    private boolean isValidInput(double input) {
        return input > 0;
    }

    public double calculateSurfaceArea() {
        return (2 * getLength() * getWidth()) + (2 * getLength() * getHeight()) + (2 * getWidth() * getHeight());
    }

    public double calculateLateralSurfaceArea() {
        return (2 * getLength() * getHeight()) + (2 * getWidth() * getHeight());
    }

    public double calculateVolume() {
        return getLength() * getHeight() * getWidth();

    }

    public double getLength() {
        return length;
    }

    private void setLength(double length) {
        if(isValidInput(length)) {
            this.length = length;
        }else {
            throw new IllegalStateException("Length cannot be zero or negative.");
        }
    }

    public double getWidth() {
        return width;
    }

    private void setWidth(double width) {
        if(isValidInput(width)) {
            this.width = width;
        }else {
            throw new IllegalStateException("Width cannot be zero or negative.");
        }
    }

    public double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        if(isValidInput(height)) {
            this.height = height;
        }else {
            throw new IllegalStateException("Height cannot be zero or negative.");
        }
    }
}
