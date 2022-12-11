package diem.unisa.softwareengineering.commands;


import javafx.scene.shape.Shape;

/**
 * This class is used to create a command that rotates a shape to the left by 1 degree
 * It relies on the command pattern so it has the execute and undo methods
 */
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
