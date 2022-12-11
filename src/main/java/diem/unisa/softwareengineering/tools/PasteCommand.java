package diem.unisa.softwareengineering.tools;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class PasteCommand extends Command{
    private Pane canva;
    private double x;
    private double y;
    private CustomClipboard clipboard;


    public PasteCommand(Pane canva, double x, double y, CustomClipboard clipboard) {
        this.canva = canva;
        this.x = x;
        this.y = y;
        this.clipboard = clipboard;
    }

    @Override
    public void execute() {
        clipboard.paste(this.canva,this.x, this.y);
    }

    @Override
    public void undo() {
        canva.getChildren().remove(clipboard.getShape());
    }
}

