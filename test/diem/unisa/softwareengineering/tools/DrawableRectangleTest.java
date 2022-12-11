package diem.unisa.softwareengineering.tools;

import diem.unisa.softwareengineering.shapes.DrawableRectangle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawableRectangleTest {

    @Test
    void testDraw() {
        DrawableRectangle rect = new DrawableRectangle();

        assertInstanceOf(Shape.class, rect.draw(4.0,2.0,4.0,2.0, Color.BLACK, Color.TRANSPARENT, "unesed text"));
        assertInstanceOf(Shape.class, rect.draw(4.0,3.0,4.0,5.0, Color.BLACK, Color.TRANSPARENT, "unesed text"));
        assertInstanceOf(Shape.class, rect.draw(4.0,5.0,4.0,3.0, Color.BLACK, Color.TRANSPARENT, "unesed text"));
        assertInstanceOf(Shape.class, rect.draw(3.0,2.0,5.0,2.0, Color.BLACK, Color.TRANSPARENT, "unesed text"));
        assertInstanceOf(Shape.class, rect.draw(5.0,2.0,3.0,2.0, Color.BLACK, Color.TRANSPARENT, "unesed text"));
        assertInstanceOf(Shape.class, rect.draw(11.0,5.0,16.0,3.0, Color.BLACK, Color.TRANSPARENT, "unesed text"));
        assertInstanceOf(Shape.class, rect.draw(11.0,3.0,16.0,5.0, Color.BLACK, Color.TRANSPARENT, "unesed text"));
        assertInstanceOf(Shape.class, rect.draw(16.0,5.0,11.0,3.0, Color.BLACK, Color.TRANSPARENT, "unesed text"));
        assertInstanceOf(Shape.class, rect.draw(16.0,3.0,11.0,5.0, Color.BLACK, Color.TRANSPARENT, "unesed text"));

    }
}