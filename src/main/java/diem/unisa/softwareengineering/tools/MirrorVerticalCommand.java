package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Shape;

public class MirrorVerticalCommand extends Command{
    private Shape shape;

    public MirrorVerticalCommand (Shape shape){
        this.shape= shape;
    }

    @Override
    public void execute() {
        this.mirrorVertical(shape);
    }

    @Override
    public void undo() {
        this.mirrorVertical(shape);
    }

    public void mirrorVertical(Shape shape){
        shape.setScaleY(shape.getScaleY() * -1);
    }
}
