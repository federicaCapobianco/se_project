package diem.unisa.softwareengineering.tools;

import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class ChangeLineColorCommand extends Command {
    private Shape shape;

    private Pane canva;

    private ColorPicker lineColorPicker;

    public ChangeLineColorCommand(Shape shape, Pane canva, ColorPicker lineColorPicker) {
        this.shape = shape;
        this.canva = canva;
        this.lineColorPicker = lineColorPicker;
    }

    @Override
    public void execute() {
        shape.setStroke(lineColorPicker.getValue());
    }

    @Override
    public void undo() {

    }
}
