package diem.unisa.softwareengineering.commands;


import javafx.scene.shape.Shape;

/**
 * This class is used to create a command that puts a shape to the front of the canvas
 * It relies on the command pattern so it has the execute and undo methods
 */
public class ToFrontCommand extends Command {
    private Shape shape;
    public ToFrontCommand(Shape shape){this.shape = shape;}

   @Override
    public void execute() {
        shape.toFront();
    }

    @Override
    public void undo() {
        shape.toBack();
    }
}
