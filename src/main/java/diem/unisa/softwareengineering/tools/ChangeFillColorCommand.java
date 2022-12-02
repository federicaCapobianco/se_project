package diem.unisa.softwareengineering.tools;

import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class ChangeFillColorCommand extends Command {
    private Shape shape;

    private Pane canva;

    private ColorPicker fillColorPicker;

    private Color colorInit;

    public ChangeFillColorCommand(Shape shape, Pane canva, ColorPicker fillColorPicker, Color colorInit) {
        this.shape = shape;
        this.canva = canva;
        this.fillColorPicker = fillColorPicker;
        this.colorInit = colorInit;
    }

    @Override
    public void execute() {
        shape.setFill(fillColorPicker.getValue());
    }

    @Override
    public void undo() {
        shape.setStroke(colorInit);
    }
}
