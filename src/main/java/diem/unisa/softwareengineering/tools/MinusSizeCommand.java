package diem.unisa.softwareengineering.tools;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class MinusSizeCommand extends Command{

    private Shape shape;

    public MinusSizeCommand(Shape shape){
        this.shape = shape;
    }

    @Override
    public void execute() {
        shape.setScaleX(shape.getScaleX()-0.1);
        shape.setScaleY(shape.getScaleY()-0.1);
    }

    @Override
    public void undo() {

    }
}
