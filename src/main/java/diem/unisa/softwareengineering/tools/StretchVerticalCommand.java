package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Shape;

public class StretchVerticalCommand extends Command{
    private Shape shape;
    private Double n;

    public StretchVerticalCommand (Shape shape, Double n){
        this.n=n;
        this.shape= shape;
    }

    @Override
    public void execute() {
        shape.setScaleY(shape.getScaleY()+n);
    }

    @Override
    public void undo() {
        shape.setScaleY(shape.getScaleY()-n);
    }
}
