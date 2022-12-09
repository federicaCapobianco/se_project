package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Shape;

public class StretchVerticalCommand extends Command{
    private Shape shape;

    public StretchVerticalCommand (Shape shape){
        this.shape= shape;
    }

    @Override
    public void execute() {
        shape.setScaleX(shape.getScaleY()+0.3);
    }

    @Override
    public void undo() {
        shape.setScaleX(shape.getScaleY()-0.3);
    }
}
