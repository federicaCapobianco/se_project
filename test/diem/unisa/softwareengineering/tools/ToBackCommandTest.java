package diem.unisa.softwareengineering.tools;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ToBackCommandTest {
    @Test
    void testExecute(){
        Shape shape1 = new Line(20, 10, 15, 30);
        Shape shape2 = new Rectangle(20, 10, 15, 30);
        Shape shape3 = new Rectangle(20, 10, 15, 30);
        Pane canva = new Pane();
        canva.getChildren().addAll(shape1, shape2, shape3);
        Command cmd = new ToBackCommand(shape2);
        cmd.execute();
        assertEquals(canva.getChildren().indexOf(shape2), 0);
    }

    @Test
    void testUndo(){
        Shape shape1 = new Line(20, 10, 15, 30);
        Shape shape2 = new Rectangle(20, 10, 15, 30);
        Shape shape3 = new Rectangle(20, 10, 15, 30);
        Pane canva = new Pane();
        canva.getChildren().addAll(shape1, shape2, shape3);
        Command cmd = new ToBackCommand(shape2);
        cmd.undo();
        assertEquals(canva.getChildren().indexOf(shape2), canva.getChildren().size()-1);
    }

}