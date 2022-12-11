package diem.unisa.softwareengineering.tools;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class CutCommand extends Command{
    private Shape shape;

    private Pane canva;

    private CustomClipboard clipboard;

    public CutCommand(Shape shape, Pane canva, CustomClipboard clipboard) {
        this.shape = shape;
        this.canva = canva;
        this.clipboard = clipboard;
    }

    @Override
    public void execute() {
        canva.getChildren().remove(shape);
        clipboard.copy(shape);
    }

    @Override
    public void undo() {
    }
}
