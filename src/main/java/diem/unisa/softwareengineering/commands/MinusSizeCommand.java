package diem.unisa.softwareengineering.commands;


import javafx.scene.shape.Shape;

/**
 * This class is used to reduce the size of a shape by 10%
 * It relies on the command pattern so it has the execute and undo methods
 */
public class MinusSizeCommand extends Command {

    private Shape shape;

    public MinusSizeCommand(Shape shape){
        this.shape = shape;
    }

    @Override
    public void execute() {
        shape.setScaleX(shape.getScaleX()-0.1);
        shape.setScaleY(shape.getScaleY()-0.1);
    }

    @Override
    public void undo() {
        shape.setScaleX(shape.getScaleX()+0.1);
        shape.setScaleY(shape.getScaleY()+0.1);
    }
}
