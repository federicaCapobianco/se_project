package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Shape;
import javafx.scene.transform.Affine;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

public class MirrorHorizontalCommand extends Command{
    private Shape shape;

    public MirrorHorizontalCommand (Shape shape){
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



