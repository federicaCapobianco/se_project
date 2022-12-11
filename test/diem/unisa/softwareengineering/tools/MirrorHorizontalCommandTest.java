package diem.unisa.softwareengineering.tools;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MirrorHorizontalCommandTest {

    @Test
    void mirrorHorizontal() {
        Pane p = new Pane();
        Shape shape = new Rectangle(10,18,10,18);
        Double scaleX = shape.getScaleX();
        p.getChildren().add(shape);
        MirrorVerticalCommand cmd = new MirrorVerticalCommand(shape);
        cmd.mirrorVertical(shape);
        assertEquals(shape.getScaleX(), -1 * scaleX);
        scaleX = shape.getScaleX();
        cmd.execute();
        assertEquals(shape.getScaleX(), -1 * scaleX);
        scaleX = shape.getScaleX();
        cmd.undo();
        assertEquals(shape.getScaleX(), -1 * scaleX );

    }
}