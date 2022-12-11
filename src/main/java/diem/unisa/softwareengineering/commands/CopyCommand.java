package diem.unisa.softwareengineering.commands;

import diem.unisa.softwareengineering.tools.CustomClipboard;
import javafx.scene.Node;

/**
 * This class represents the command to copy a shape.
 * It relies on the command pattern so it has the execute and undo methods, the undo is empty because the copy command doesn't have an undo
 */
public class CopyCommand extends Command {
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
