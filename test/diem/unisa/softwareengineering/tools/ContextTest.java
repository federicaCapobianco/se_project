package diem.unisa.softwareengineering.tools;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ContextTest {

    @Test
    void testChangeState() {
        Context handler = new Context();
        handler.changeState(new DrawableLine());
        assertInstanceOf(DrawableLine.class, handler.getShape());

        handler.changeState(new DrawableRectangle());
        assertInstanceOf(DrawableRectangle.class, handler.getShape());

        handler.changeState(new DrawableEllipse());
        assertInstanceOf(DrawableEllipse.class, handler.getShape());
    }

    @Test
    void testDraw() {
        Context handler = new Context();
        handler.changeState(new DrawableLine());
        assertInstanceOf(Shape.class, handler.draw());

        handler.changeState(new DrawableRectangle());
        assertInstanceOf(Shape.class, handler.draw());

        handler.changeState(new DrawableEllipse());
        assertInstanceOf(Shape.class, handler.draw());
    }

    @Test
    void testGetSet() {
        Context handler = new Context();
        handler.setxS(3.0);
        handler.setxE(4.0);
        handler.setyS(3.0);
        handler.setyE(4.0);
        assertEquals(3.0, handler.getxS());
        assertEquals(4.0, handler.getxE());
        assertEquals(3.0, handler.getyS());
        assertEquals(4.0, handler.getyE());
    }


}