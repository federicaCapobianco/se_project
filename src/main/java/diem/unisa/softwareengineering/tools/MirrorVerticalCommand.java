package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Shape;

public class MirrorVerticalCommand extends Command{
    private Shape shape;

    public MirrorVerticalCommand (Shape shape){
        this.shape= shape;
    }

    @Override
    public void execute() {
        shape.setScaleY(-1);
    }

    @Override
    public void undo() {
        shape.setScaleY(1);
    }
}
