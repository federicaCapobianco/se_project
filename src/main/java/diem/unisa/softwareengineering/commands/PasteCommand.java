package diem.unisa.softwareengineering.commands;

import diem.unisa.softwareengineering.tools.CustomClipboard;
import javafx.scene.layout.Pane;

/**
 * This class is used to paste a shape from the clipboard to the canvas
 * It relies on the command pattern so it has the execute and undo methods
 */
public class PasteCommand extends Command {
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
