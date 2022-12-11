package diem.unisa.softwareengineering.commands;


import javafx.scene.shape.Shape;

/**
 * This class is used to create a command that stretches a shape vertically by the number inserted by the user
 * It relies on the command pattern so it has the execute and undo methods
 */
public class StretchVerticalCommand extends Command {
    private Shape shape;
    private Double n;

    public StretchVerticalCommand (Shape shape, Double n){
        this.n=n;
        this.shape= shape;
    }

    @Override
    public void execute() {
        shape.setScaleY(shape.getScaleY() + n);
    }

    @Override
    public void undo() {
        shape.setScaleY(shape.getScaleY() - n);
    }
}
