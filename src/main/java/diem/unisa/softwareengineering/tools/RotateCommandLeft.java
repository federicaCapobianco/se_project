package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;

public class RotateCommandLeft extends Command {

    private Shape shape;

    public RotateCommandLeft (Shape shape){
        this.shape= shape;
    }

    @Override
    public void execute() {
        shape.getTransforms().add(new Rotate(-1,shape.getLayoutBounds().getMinX(),shape.getLayoutBounds().getMinY()));
    }

    @Override
    public void undo() {
        shape.getTransforms().add(new Rotate(1,shape.getLayoutBounds().getMinX(),shape.getLayoutBounds().getMinY()));

    }
}
