package diem.unisa.softwareengineering.tools;

import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class ChangeLineColorCommand extends Command {
    private Shape shape;

    private Pane canva;

    private ColorPicker lineColorPicker;
    private Color colorInit;

    public ChangeLineColorCommand(Shape shape, Pane canva, ColorPicker lineColorPicker, Color colorInit) {
        this.shape = shape;
        this.canva = canva;
        this.lineColorPicker = lineColorPicker;
        this.colorInit = colorInit;
    }

    @Override
    public void execute() {
        System.out.println("color prima della modifica: " + colorInit);
        shape.setStroke(lineColorPicker.getValue());
        System.out.println("color dopo la modifica: " + lineColorPicker.getValue());
    }

    @Override
    public void undo() {
        shape.setStroke(colorInit);
    }
}
