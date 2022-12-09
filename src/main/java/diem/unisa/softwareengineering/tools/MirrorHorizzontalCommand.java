package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Shape;
import javafx.scene.transform.Affine;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

public class MirrorHorizzontalCommand extends Command{
    private Shape shape;

    public MirrorHorizzontalCommand (Shape shape){
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



