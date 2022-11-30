package diem.unisa.softwareengineering.tools;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class PlusSizeCommand extends Command{
    private Shape shape;
    private Pane canva;

    public PlusSizeCommand(Shape shape, Pane canva){
        this.shape = shape;
        this.canva = canva;
    }

    @Override
    public void execute() {
        shape.setScaleX(shape.getScaleX()+0.1);
        shape.setScaleY(shape.getScaleY()+0.1);
        //canva.getChildren().remove(shape);
    }

    @Override
    public void undo(){

    }
}
