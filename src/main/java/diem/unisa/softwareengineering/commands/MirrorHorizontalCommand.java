package diem.unisa.softwareengineering.commands;

import javafx.scene.shape.Shape;

/**
 * This class is used to mirror a shape horizontally
 * It relies on the command pattern so it has the execute and undo methods
 */
public class MirrorHorizontalCommand extends Command {
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
        shape.setScaleY(shape.getScaleY() * -1);
    }

}
