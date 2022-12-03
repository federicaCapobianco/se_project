package diem.unisa.softwareengineering.tools;

import javafx.application.Platform;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeFillColorCommandTest {
    @BeforeAll
    static void initJfxRuntime() {
        Platform.startup(() -> {});
    }

    Color colorInit = Color.BLUE;

    @Test
    void execute() {
        Pane p = new Pane();
        Shape shape = new Rectangle(10,18,10,18);
        p.getChildren().add(shape);
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.RED);
        Command cmd = new ChangeFillColorCommand( shape, p, colorPicker, colorInit );
        cmd.execute();
        assertEquals(shape.getFill(), colorPicker.getValue());
    }

    @Test
    void undo() {
        Pane p = new Pane();
        Shape shape = new Rectangle(10,18,10,18);
        p.getChildren().add(shape);
        ColorPicker colorPicker = new ColorPicker();
        Command cmd = new ChangeFillColorCommand( shape, p, colorPicker, colorInit );
        cmd.undo();
        assertEquals(shape.getFill(), colorInit);
    }
}