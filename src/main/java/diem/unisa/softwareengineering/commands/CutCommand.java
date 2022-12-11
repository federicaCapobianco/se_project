package diem.unisa.softwareengineering.commands;

import diem.unisa.softwareengineering.tools.CustomClipboard;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

/**
 * This class is used to delete and copy shape from the canvas
 * It relies on the command pattern so it has the execute and undo methods
 */
public class CutCommand extends Command {
    private Shape shape;
    private Pane canva;
    private CustomClipboard clipboard;

    public CutCommand(Shape shape, Pane canva, CustomClipboard clipboard){
        this.shape = shape;
        this.canva = canva;
        this.clipboard = clipboard;
    }

    @Override
    public void execute(){
        canva.getChildren().remove(shape);
        clipboard.copy(shape);
    }

    @Override
    public void undo(){
        canva.getChildren().add(shape);
    }
}
