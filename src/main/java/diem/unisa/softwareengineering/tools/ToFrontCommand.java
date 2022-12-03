package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Shape;

public class ToFrontCommand extends Command{
    private Shape shape;
    public ToFrontCommand(Shape shape){this.shape = shape;}

   @Override
    public void execute() {
        shape.toFront();
    }

    @Override
    public void undo() {
        shape.toBack();
    }
}
