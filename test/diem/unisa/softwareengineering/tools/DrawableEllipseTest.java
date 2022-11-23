package diem.unisa.softwareengineering.tools;

import org.junit.jupiter.api.Test;

import java.awt.*;

import javafx.scene.shape.Shape;

import static org.junit.jupiter.api.Assertions.*;

class DrawableEllipseTest {

    @Test
    void draw() {
        DrawableEllipse elipse = new DrawableEllipse();
        assertInstanceOf(Shape.class, elipse.draw(10.0,10.0,50.0,50.0));
        assertInstanceOf(Shape.class, elipse.draw(50.0,50.0,10.0,10.0));
        assertInstanceOf(Shape.class, elipse.draw(50.0,50.0,50.0,50.0));
        assertInstanceOf(Shape.class, elipse.draw(-10.0,-10.0,50.0,50.0));
        assertInstanceOf(Shape.class, elipse.draw(10.0,10.0,-50.0,-50.0));
        assertInstanceOf(Shape.class, elipse.draw(-10.0,-10.0,-50.0,-50.0));
    }
}