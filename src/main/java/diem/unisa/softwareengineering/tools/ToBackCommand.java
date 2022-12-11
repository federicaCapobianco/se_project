package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Shape;

public class ToBackCommand extends Command{

    private Shape shape;

    public ToBackCommand(Shape shape){
        this.shape = shape;
    }

    @Override
    public void execute() {
        shape.toBack();
    }

    @Override
    public void undo() {
        shape.toFront();
    }
}
