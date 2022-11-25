package diem.unisa.softwareengineering.tools;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToolsTest {

    @Test
    void testChangeState() {
        Tools handler = new Tools();
        handler.changeState(new DrawableLine());
        assertInstanceOf(DrawableLine.class, handler.getShape());

        handler.changeState(new DrawableRectangle());
        assertInstanceOf(DrawableRectangle.class, handler.getShape());

        handler.changeState(new DrawableEllipse());
        assertInstanceOf(DrawableEllipse.class, handler.getShape());
    }

    @Test
    void testDraw() {
        Tools handler = new Tools();
        handler.changeState(new DrawableLine());
        assertInstanceOf(Shape.class, handler.draw());

        handler.changeState(new DrawableRectangle());
        assertInstanceOf(Shape.class, handler.draw());

        handler.changeState(new DrawableEllipse());
        assertInstanceOf(Shape.class, handler.draw());
    }

    @Test
    void testGetSet() {
        Tools handler = new Tools();
        handler.setxS(3.0);
        handler.setxE(4.0);
        handler.setyS(3.0);
        handler.setyE(4.0);
        assertEquals(3.0, handler.getxS());
        assertEquals(4.0, handler.getxE());
        assertEquals(3.0, handler.getyS());
        assertEquals(4.0, handler.getyE());
    }

    @Test
    void testGetSetLineColor(){
        Tools handler = new Tools();
        handler.setShapeLineColor(Color.BLACK);
        assertEquals(Color.BLACK, handler.getShapeLineColor());
    }

    @Test
    void testGetSetFillColor(){
        Tools handler = new Tools();
        handler.setShapeFillColor(Color.BLACK);
        assertEquals(Color.BLACK, handler.getShapeFillColor());
    }

}