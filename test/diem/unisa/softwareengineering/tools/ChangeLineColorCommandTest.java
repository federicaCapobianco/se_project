package diem.unisa.softwareengineering.tools;

import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

import javafx.application.Platform;



class ChangeLineColorCommandTest {
    @BeforeAll
    static void initJfxRuntime() {
        Platform.startup(() -> {});
    }

    Color colorInit = Color.BLUE;
    @Test
    void testExecute(){

        Pane p = new Pane();
        Shape shape = new Rectangle(10,18,10,18);
        p.getChildren().add(shape);
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.RED);
        Command cmd = new ChangeLineColorCommand( shape, p, colorPicker, colorInit );
        cmd.execute();
        assertEquals(shape.getStroke(), colorPicker.getValue());
    }

    @Test
    void testUndo() {
        Pane p = new Pane();
        Shape shape = new Rectangle(10,18,10,18);
        p.getChildren().add(shape);
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.RED);
        Command cmd = new ChangeLineColorCommand( shape, p, colorPicker, colorInit );
        cmd.undo();
        assertEquals(shape.getStroke(), colorInit);
    }
}