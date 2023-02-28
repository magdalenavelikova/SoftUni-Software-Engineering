package solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces;

public class ConsoleRenderer implements Renderer{

    @Override
    public void render( Shape shape) {
        System.out.printf("Draw shape %s with area %.2f",shape.getClass().getSimpleName(),shape.getArea());
    }
}
