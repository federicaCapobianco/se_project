package diem.unisa.softwareengineering.tools;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class ChangeSizeCommand extends Command{
    private Shape shape;
    private Pane canva;

    public ChangeSizeCommand(Shape shape, Pane canva){
        this.shape = shape;
        this.canva = canva;
    }

    @Override
    public void execute() {
        //canva.getChildren().remove(shape);
    }

    @Override
    public void undo(){

    }
}
