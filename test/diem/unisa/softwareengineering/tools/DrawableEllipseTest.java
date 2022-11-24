package diem.unisa.softwareengineering.tools;

import org.junit.jupiter.api.Test;

import java.awt.*;

import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;

import static org.junit.jupiter.api.Assertions.*;

class DrawableEllipseTest {

    @Test
    void testDraw() {
        DrawableEllipse elipse = new DrawableEllipse();

        assertInstanceOf(Shape.class, elipse.draw(150.0,150.0,80.0,220.0, Color.BLACK));
        assertInstanceOf(Shape.class, elipse.draw(150.0,150.0,150.0,220.0, Color.BLACK));
        assertInstanceOf(Shape.class, elipse.draw(150.0,150.0,220.0,220.0, Color.BLACK));
        assertInstanceOf(Shape.class, elipse.draw(150.0,150.0,220.0,150.0, Color.BLACK));
        assertInstanceOf(Shape.class, elipse.draw(150.0,150.0,220.0,80.0, Color.BLACK));
        assertInstanceOf(Shape.class, elipse.draw(150.0,150.0,150.0,80.0, Color.BLACK));
        assertInstanceOf(Shape.class, elipse.draw(150.0,150.0,80.0,80.0, Color.BLACK));
        assertInstanceOf(Shape.class, elipse.draw(150.0,150.0,80.0,150.0, Color.BLACK));
        assertInstanceOf(Shape.class, elipse.draw(150.0,150.0,150.0,150.0, Color.BLACK));

    }
}