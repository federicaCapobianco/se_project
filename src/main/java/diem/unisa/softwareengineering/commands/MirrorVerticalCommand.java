package diem.unisa.softwareengineering.commands;

import javafx.scene.shape.Shape;

/**
 * This class is used to mirror a shape vertically
 * It relies on the command pattern so it has the execute and undo methods
 */
public class MirrorVerticalCommand extends Command {
        private Shape shape;

        public MirrorVerticalCommand (Shape shape){
            this.shape= shape;
        }

        @Override
        public void execute() {
            this.mirrorVertical(shape);
        }

        @Override
        public void undo() {
            this.mirrorVertical(shape);
        }

        public void mirrorVertical(Shape shape){
            shape.setScaleX(shape.getScaleX() * -1);
        }

}
