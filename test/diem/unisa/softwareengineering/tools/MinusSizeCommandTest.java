package diem.unisa.softwareengineering.tools;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinusSizeCommandTest {

    private double prevX;
    private double prevY;
    private Command cmd;

    @Test
    void testExecute(){
        Shape line = new Line(10,15,20,35);
        prevX = line.getScaleX();
        prevY = line.getScaleY();
        cmd = new MinusSizeCommand(line);
        cmd.execute();
        assertTrue(line.getScaleX() < prevX);
        assertTrue(line.getScaleY() < prevY);

        Shape rect = new Rectangle(10,15,20,35);
        prevX = rect.getScaleX();
        prevY = rect.getScaleY();
        cmd = new MinusSizeCommand(rect);
        cmd.execute();
        assertTrue(rect.getScaleX() < prevX);
        assertTrue(rect.getScaleY() < prevY);

        Shape ellipse = new Rectangle(10,15,20,35);
        prevX = ellipse.getScaleX();
        prevY = ellipse.getScaleY();
        cmd = new MinusSizeCommand(ellipse);
        cmd.execute();
        assertTrue(ellipse.getScaleX() < prevX);
        assertTrue(ellipse.getScaleY() < prevY);
    }

    @Test
    void testUndo() {

    }
}