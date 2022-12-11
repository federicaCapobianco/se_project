package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Shape;

public class MirrorVerticalCommand extends Command{
    private Shape shape;

    public MirrorVerticalCommand (Shape shape){
        this.shape= shape;
    }

    @Override
    public void execute() {
        shape.setScaleX(-1);
    }

    @Override
    public void undo() {
        shape.setScaleX(1);
    }
}
