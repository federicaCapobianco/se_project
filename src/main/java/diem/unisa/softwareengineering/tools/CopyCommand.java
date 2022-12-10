package diem.unisa.softwareengineering.tools;

import javafx.scene.Node;

public class CopyCommand extends Command{
    Node shape;
    CustomClipboard clipboard;
    public CopyCommand(Node shape, CustomClipboard clipboard) {
        this.shape = shape;
        this.clipboard = new CustomClipboard();
    }

    @Override
    public void execute() {
        clipboard.copy(shape);
    }

    @Override
    public void undo() {
    }
}
