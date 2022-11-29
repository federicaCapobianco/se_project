package diem.unisa.softwareengineering.tools;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class DeleteCommand extends Command{
    private ArrayList<Shape> shape;

    private Pane canva;

    public DeleteCommand(ArrayList<Shape> shape, Pane canva) {
        this.shape = shape;
        this.canva = canva;
    }

    @Override
    public void execute() {
        //ELIMINO IL RIFERIMENTO ALLA SHAPE
        //ELIMINO LA FIGURA DAL CANVA
        for (Shape s : shape) {
            canva.getChildren().remove(s);
            //shape.remove(s);
        }

    }

    @Override
    public void undo() {
        for (Shape s : shape) {
            canva.getChildren().add(s);
            //shape.add(s);
        }
    }
}


//shapeEditor.clearSelectedNodes();
