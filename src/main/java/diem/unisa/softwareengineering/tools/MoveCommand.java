package diem.unisa.softwareengineering.tools;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class MoveCommand extends Command{

    private Shape shape;
    private Pane pane;
    private double x;
    private double y;


    public MoveCommand(Shape shape, Pane pane, double x, double y) {
        this.shape = shape;
        this.pane = pane;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
       shape.setLayoutX(x - shape.getLayoutBounds().getMinX());
       shape.setLayoutY(y - shape.getLayoutBounds().getMinY());
    }

    @Override
    public void undo() {
    }
}
