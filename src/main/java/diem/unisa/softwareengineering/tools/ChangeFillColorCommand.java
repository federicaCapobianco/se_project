package diem.unisa.softwareengineering.tools;

import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class ChangeFillColorCommand extends Command {
    private Shape shape;

    private Pane canva;

    private ColorPicker fillColorPicker;

    public ChangeFillColorCommand(Shape shape, Pane canva, ColorPicker fillColorPicker) {
        this.shape = shape;
        this.canva = canva;
        this.fillColorPicker = fillColorPicker;
    }

    @Override
    public void execute() {
        shape.setFill(fillColorPicker.getValue());
    }

    @Override
    public void undo() {

    }
}
