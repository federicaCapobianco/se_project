package diem.unisa.softwareengineering.tools;

import diem.unisa.softwareengineering.commands.Command;
import diem.unisa.softwareengineering.commands.DeleteCommand;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteCommandTest {

    @Test
    void testExecute(){
        Pane p = new Pane();
        Shape shape = new Line(10,15,20,35);
        p.getChildren().add(shape);
        Command cmd = new DeleteCommand( shape, p );
        cmd.execute();
        assertFalse(p.getChildren().contains(shape));
    }

    @Test
    void testUndo() {
        Pane p = new Pane();
        Shape shape = new Line(10,15,20,35);
        p.getChildren().add(shape);
        Command cmd = new DeleteCommand( shape, p );
        cmd.execute();
        cmd.undo();
        assertTrue(p.getChildren().contains(shape));
    }
}