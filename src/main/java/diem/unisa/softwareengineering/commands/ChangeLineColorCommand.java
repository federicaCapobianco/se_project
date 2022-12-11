package diem.unisa.softwareengineering.commands;


import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 * This class is used to change the line color of a shape
 * It relies on the command pattern so it has the execute and undo methods
 */
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
        shape.setStroke(lineColorPicker.getValue());
    }

    @Override
    public void undo() {
        shape.setStroke(colorInit);
    }
}
