package solidLab.p01_SingleResponsibility.p01_DrawingShape;

import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingManager;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Renderer;
import solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;


public class DrawingManagerImpl implements DrawingManager {


    private final Renderer renderer;

    public DrawingManagerImpl(Renderer renderer) {
        this.renderer = renderer;
    }


    @Override
    public void draw(Shape shape) {
renderer.render(shape);
    }
}
