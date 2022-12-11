package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Shape;

public class MirrorHorizontalCommand extends Command{
    private Shape shape;

    public MirrorHorizontalCommand (Shape shape){
        this.shape= shape;
    }

    @Override
    public void execute() {
        this.mirrorHorizontal(shape);
    }

    @Override
    public void undo() {
        this.mirrorHorizontal(shape);
    }

    public void mirrorHorizontal(Shape shape){
        shape.setScaleX(shape.getScaleX() * -1);
    }
}



