package diem.unisa.softwareengineering.tools;

import diem.unisa.softwareengineering.commands.Command;
import diem.unisa.softwareengineering.commands.RotateCommandLeft;
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
        Double value = shape.rotateProperty().getValue();
        Command cmd = new RotateCommandLeft(shape);
        cmd.execute();
        assertEquals(value - 1 , shape.rotateProperty().getValue());
    }

    @Test
    void undo() {
        Pane p = new Pane();
        Shape shape = new Rectangle(10,18,10,18);
        p.getChildren().add(shape);
        Double value = shape.rotateProperty().getValue();
        Command cmd = new RotateCommandLeft(shape);
        cmd.undo();
        assertEquals(value + 1 , shape.rotateProperty().getValue());
    }
}