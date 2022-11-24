package diem.unisa.softwareengineering.tools;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import javafx.scene.shape.Shape;

import static org.junit.jupiter.api.Assertions.*;

class DrawableLineTest {

    @Test
    void testDraw() {
        DrawableLine line = new DrawableLine();
        assertInstanceOf(Shape.class, line.draw(3.0, 4.0, 4.0,3.0, Color.BLACK, Color.TRANSPARENT));
        assertInstanceOf(Shape.class, line.draw(3.0, 3.0, 4.0,4.0, Color.BLACK, Color.TRANSPARENT));
        assertInstanceOf(Shape.class, line.draw(4.0, 4.0, 3.0,3.0, Color.BLACK, Color.TRANSPARENT));
        assertInstanceOf(Shape.class, line.draw(4.0, 4.0, 4.0,3.0, Color.BLACK, Color.TRANSPARENT));
        assertInstanceOf(Shape.class, line.draw(3.0, 4.0, 3.0,3.0, Color.BLACK, Color.TRANSPARENT));
        assertInstanceOf(Shape.class, line.draw(3.0, 3.0, 3.0,4.0, Color.BLACK, Color.TRANSPARENT));
        assertInstanceOf(Shape.class, line.draw(3.0, 4.0, 4.0,4.0, Color.BLACK, Color.TRANSPARENT));
        assertInstanceOf(Shape.class, line.draw(4.0, 4.0, 3.0,4.0, Color.BLACK, Color.TRANSPARENT));
        assertInstanceOf(Shape.class, line.draw(3.0, 4.0, 3.0,4.0, Color.BLACK, Color.TRANSPARENT));
    }
}