package diem.unisa.softwareengineering.tools;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateCommandLeftTest {

    @Test
    void execute() {
        Pane p = new Pane();
        Shape shape = new Rectangle(10,18,10,18);
        p.getChildren().add(shape);
        Command cmd = new RotateCommandRight(shape);
        cmd.execute();
        assertEquals(80 + shape.getLayoutBounds().getMinX(), shape.getTransforms());
        assertEquals(80 + shape.getLayoutBounds().getMinY(), shape.getTransforms());
    }

    @Test
    void undo() {
        Pane p = new Pane();
        Shape shape = new Rectangle(10,18,10,18);
        p.getChildren().add(shape);
        Command cmd = new RotateCommandRight(shape);
        cmd.execute();
        assertEquals(80 - shape.getLayoutBounds().getMinX(), shape.getTransforms());
        assertEquals(80 - shape.getLayoutBounds().getMinY(), shape.getTransforms());
    }
}