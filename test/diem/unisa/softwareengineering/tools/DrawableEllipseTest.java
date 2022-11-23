package diem.unisa.softwareengineering.tools;

import org.junit.jupiter.api.Test;

import java.awt.*;

import javafx.scene.shape.Shape;

import static org.junit.jupiter.api.Assertions.*;

class DrawableEllipseTest {

    @Test
    void draw() {
        DrawableEllipse elipse = new DrawableEllipse();

        assertInstanceOf(Shape.class, elipse.draw(150.0,150.0,80.0,220.0));
        assertInstanceOf(Shape.class, elipse.draw(150.0,150.0,150.0,220.0));
        assertInstanceOf(Shape.class, elipse.draw(150.0,150.0,220.0,220.0));
        assertInstanceOf(Shape.class, elipse.draw(150.0,150.0,220.0,150.0));
        assertInstanceOf(Shape.class, elipse.draw(150.0,150.0,220.0,80.0));
        assertInstanceOf(Shape.class, elipse.draw(150.0,150.0,150.0,80.0));
        assertInstanceOf(Shape.class, elipse.draw(150.0,150.0,80.0,80.0));
        assertInstanceOf(Shape.class, elipse.draw(150.0,150.0,80.0,150.0));
        assertInstanceOf(Shape.class, elipse.draw(150.0,150.0,150.0,150.0));

    }
}