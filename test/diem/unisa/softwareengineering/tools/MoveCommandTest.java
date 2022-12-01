package diem.unisa.softwareengineering.tools;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import org.junit.jupiter.api.Test;

import static java.lang.Math.round;
import static org.junit.jupiter.api.Assertions.*;

class MoveCommandTest {

    @Test
    void testExecute() {
        //SPOSTO LA FIGURA IN UN PUNTO X,Y MIO E VEDO SE LA POSIZIONE SI TROVA
        Pane p = new Pane();
        Shape shape = new Line(10,15,20,35);
        p.getChildren().add(shape);
        Command cmd = new MoveCommand( shape, p,50.0,50.0 );
        cmd.execute();
        assertEquals(50.0, shape.getLayoutX());
        assertEquals(50.0, shape.getLayoutY());  //se muovo il centro non dovrei avere problemi
    }

    @Test
    void testUndo() {

    }
}