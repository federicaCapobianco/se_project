package diem.unisa.softwareengineering.tools;

import diem.unisa.softwareengineering.commands.ChangeFillColorCommand;
import diem.unisa.softwareengineering.commands.MirrorHorizontalCommand;
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
        Double scaleY = shape.getScaleY();
        p.getChildren().add(shape);
        MirrorHorizontalCommand cmd = new MirrorHorizontalCommand(shape);
        cmd.mirrorHorizontal(shape);
        assertEquals(shape.getScaleY(), -1 * scaleY);
        scaleY = shape.getScaleY();
        cmd.execute();
        assertEquals(shape.getScaleY(), -1 * scaleY);
        scaleY = shape.getScaleY();
        cmd.undo();
        assertEquals(shape.getScaleY(), -1 * scaleY);

    }
}