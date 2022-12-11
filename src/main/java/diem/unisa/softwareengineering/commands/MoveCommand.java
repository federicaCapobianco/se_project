package diem.unisa.softwareengineering.commands;


import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

/**
 * This class is used to create a command that moves a shape
 * It relies on the command pattern so it has the execute and undo methods
 */
public class MoveCommand extends Command {

    private Shape shape;
    private Pane pane;
    private double x;
    private double y;

    private double prevX;
    private double prevY;


    public MoveCommand(Shape shape, Pane pane, double x, double y) {
        this.shape = shape;
        this.pane = pane;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        this.prevX = shape.getLayoutX();
        this.prevY = shape.getLayoutY();
       shape.setLayoutX(x - shape.getLayoutBounds().getMinX());
       shape.setLayoutY(y - shape.getLayoutBounds().getMinY());
    }

    @Override
    public void undo() {
        shape.setLayoutX(prevX);
        shape.setLayoutY(prevY);
    }
}
