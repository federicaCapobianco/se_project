package diem.unisa.softwareengineering.commands;

import javafx.scene.shape.Shape;

/**
 * This class is used to stretch a shape horizontally
 * It relies on the command pattern so it has the execute and undo methods
 */
public class StretchHorizontalCommand extends Command {
        private Shape shape;
        private Double n;

        public StretchHorizontalCommand (Shape shape, Double n){
            this.shape= shape;
            this.n=n;
        }

        @Override
        public void execute() {
            shape.setScaleX(shape.getScaleX() + n);
        }

        @Override
        public void undo() {
            shape.setScaleX(shape.getScaleX()  - n);
        }
}
