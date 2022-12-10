package diem.unisa.softwareengineering.tools;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StretchVerticalCommandTest {

    private double prevY;

    @Test
    void execute() {
        Pane p = new Pane();
        Shape shape = new Rectangle(10,18,10,18);
        p.getChildren().add(shape);
        double n = 3;
        prevY = shape.getScaleY();
        Command cmd = new StretchVerticalCommand(shape,n);
        cmd.execute();
        assertTrue(shape.getScaleY() > prevY);

    }

    @Test
    void undo() {
        Pane p = new Pane();
        Shape shape = new Rectangle(10,18,10,18);
        p.getChildren().add(shape);
        double n = 3;
        prevY = shape.getScaleY();
        Command cmd = new StretchVerticalCommand(shape,n);
        cmd.undo();
        assertTrue(shape.getScaleY() < prevY);

    }
}