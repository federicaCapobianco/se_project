package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Shape;

public class RotateCommandLeft extends Command {

    private Shape shape;

    public RotateCommandLeft (Shape shape){
        this.shape= shape;
    }

    @Override
    public void execute() {
        shape.rotateProperty().setValue(shape.getRotate()-1);
   }

    @Override
    public void undo() {
        shape.rotateProperty().setValue(shape.getRotate()+1);
    }
}
