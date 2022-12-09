package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Shape;

public class StretchHorizontalCommand extends Command{

    private Shape shape;
    private Double n;

    public StretchHorizontalCommand (Shape shape, Double n){
        this.shape= shape;
        this.n=n;
    }

    @Override
    public void execute() {
        shape.setScaleX(shape.getScaleX()+n);
    }

    @Override
    public void undo() {
        shape.setScaleX(shape.getScaleX()-n);
    }
}
