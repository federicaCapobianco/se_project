package diem.unisa.softwareengineering.tools;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StretchHorizontalCommandTest {
    private double prevX;

    @Test
    void execute() {
        Pane p = new Pane();
        Shape shape = new Rectangle(10,18,10,18);
        p.getChildren().add(shape);
        double n = 3;
        prevX = shape.getScaleX();
        Command cmd = new StretchHorizontalCommand(shape,n);
        cmd.execute();
        assertTrue(shape.getScaleX() > prevX);

    }

    @Test
    void undo() {
        Pane p = new Pane();
        Shape shape = new Rectangle(10,18,10,18);
        p.getChildren().add(shape);
        double n = 3;
        prevX = shape.getScaleX();
        Command cmd = new StretchHorizontalCommand(shape,n);
        cmd.undo();
        assertTrue(shape.getScaleX() < prevX);

    }
}