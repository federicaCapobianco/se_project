package diem.unisa.softwareengineering.tools;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawableTextTest {

    @Test
    void draw() {
        DrawableText testo = new DrawableText();
        assertInstanceOf(Shape.class, testo.draw(0.0, 0.0, 3.0, 0.0, Color.BLACK, Color.BLACK, "Test for Text"));
    }
}