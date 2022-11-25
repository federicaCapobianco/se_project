package diem.unisa.softwareengineering.tools;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ToolsTest {
    @Test
    void testGetSet() {
        Tools handler = new Tools();
        handler.setxS(3.0);
        handler.setxE(4.0);
        handler.setyS(3.0);
        handler.setyE(4.0);
        handler.setShapeLineColor(Color.BLACK);
        handler.setShapeFillColor(Color.BLACK);
        assertEquals(3.0, handler.getxS());
        assertEquals(4.0, handler.getxE());
        assertEquals(3.0, handler.getyS());
        assertEquals(4.0, handler.getyE());
        assertEquals(Color.BLACK, handler.getShapeLineColor());
        assertEquals(Color.BLACK, handler.getShapeFillColor());
    }

    @Test
    void changeState() {
        Tools handler = new Tools();
        handler.changeState(new DrawableLine());
        assertInstanceOf(DrawableLine.class, handler.getShape());

        handler.changeState(new DrawableRectangle());
        assertInstanceOf(DrawableRectangle.class, handler.getShape());

        handler.changeState(new DrawableEllipse());
        assertInstanceOf(DrawableEllipse.class, handler.getShape());
    }

    @Test
    void draw() {
        Tools handler = new Tools();
        handler.changeState(new DrawableLine());
        assertInstanceOf(Shape.class, handler.draw());

        handler.changeState(new DrawableRectangle());
        assertInstanceOf(Shape.class, handler.draw());

        handler.changeState(new DrawableEllipse());
        assertInstanceOf(Shape.class, handler.draw());
    }

    @Test
    void getSelectedNodes() {
        Tools handler = new Tools();
        assertInstanceOf(ArrayList.class, handler.getSelectedNodes());
    }

    @Test
    void addSelectedNode() {
        Tools handler = new Tools();
        handler.addSelectedNode(new Line());
        assertEquals(1, handler.getSelectedNodes().size());
    }

    @Test
    void removeSelectedNode() {
        Tools handler = new Tools();
        Line line = new Line();
        handler.addSelectedNode(line);
        handler.removeSelectedNode(line);
        assertEquals(0, handler.getSelectedNodes().size());
    }

    @Test
    void clearSelectedNodes() {
        Tools handler = new Tools();
        handler.addSelectedNode(new Line());
        handler.clearSelectedNodes();
        assertEquals(0, handler.getSelectedNodes().size());
    }
}