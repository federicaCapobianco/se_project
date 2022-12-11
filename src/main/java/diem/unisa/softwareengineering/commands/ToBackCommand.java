package diem.unisa.softwareengineering.commands;


import javafx.scene.shape.Shape;

/**
 * This class is used to create a command that puts a shape to the back of the canvas
 * It relies on the command pattern so it has the execute and undo methods
 */
public class ToBackCommand extends Command {

    private Shape shape;

    public ToBackCommand(Shape shape){
        this.shape = shape;
    }

    @Override
    public void execute() {
        shape.toBack();
    }

    @Override
    public void undo() {
        shape.toFront();
    }
}
