package diem.unisa.softwareengineering.commands;


import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;


/**
 * This class is used to delete a shape from the canvas
 * It relies on the command pattern so it has the execute and undo methods
 */
public class DeleteCommand extends Command {
    private Shape shape;
    private Pane canva;

    public DeleteCommand(Shape shape, Pane canva) {
        this.shape = shape;
        this.canva = canva;
    }

    @Override
    public void execute() {
        canva.getChildren().remove(shape);
    }

    @Override
    public void undo() {
        canva.getChildren().add(shape);
    }
}