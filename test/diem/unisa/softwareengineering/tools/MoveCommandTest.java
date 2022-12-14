package diem.unisa.softwareengineering.tools;

import diem.unisa.softwareengineering.commands.Command;
import diem.unisa.softwareengineering.commands.MoveCommand;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import org.junit.jupiter.api.Test;

import static java.lang.Math.round;
import static org.junit.jupiter.api.Assertions.*;

class MoveCommandTest {

    @Test
    void testExecute() {
        Pane p = new Pane();
        Shape shape = new Line(15,15,20,20);
        p.getChildren().add(shape);
        Command cmd = new MoveCommand( shape, p,40.0,40.0 );
        cmd.execute();
        assertEquals(40 - shape.getLayoutBounds().getMinX(), shape.getLayoutX());
        assertEquals(40 - shape.getLayoutBounds().getMinY(), shape.getLayoutY());
    }

    @Test
    void testUndo() {
        Pane p = new Pane();
        Shape shape = new Line(15,15,20,20);
        p.getChildren().add(shape);
        //recupera posizioni della shape
        double x = shape.getLayoutX();
        double y = shape.getLayoutY();
        Command cmd = new MoveCommand( shape, p,40.0,40.0 );
        cmd.execute();
        cmd.undo();
        assertEquals(x , shape.getLayoutX());
        assertEquals(y, shape.getLayoutY());
    }
}