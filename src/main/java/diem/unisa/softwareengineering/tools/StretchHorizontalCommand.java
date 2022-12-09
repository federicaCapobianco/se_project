package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Shape;

public class StretchHorizontalCommand extends Command{

    private Shape shape;

    public StretchHorizontalCommand (Shape shape){
        this.shape= shape;
    }

    @Override
    public void execute() {
        shape.setScaleY(shape.getScaleY()+0.3);
    }

    @Override
    public void undo() {
        shape.setScaleY(shape.getScaleY()-0.3);
    }
}
