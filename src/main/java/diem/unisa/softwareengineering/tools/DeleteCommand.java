package diem.unisa.softwareengineering.tools;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class DeleteCommand extends Command{
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


//shapeEditor.clearSelectedNodes();
