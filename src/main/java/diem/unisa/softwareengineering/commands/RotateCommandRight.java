package diem.unisa.softwareengineering.commands;


import javafx.scene.shape.Shape;

/**
 * This class is used to create a command that rotates a shape to the left by 1 degree
 */
public class RotateCommandRight extends Command {
    private Shape shape;

    public RotateCommandRight (Shape shape){
        this.shape= shape;
    }

    @Override
    public void execute() {
        shape.rotateProperty().setValue(shape.getRotate()+1);
    }

    @Override
    public void undo() {
        shape.rotateProperty().setValue(shape.getRotate()-1);
    }
}
