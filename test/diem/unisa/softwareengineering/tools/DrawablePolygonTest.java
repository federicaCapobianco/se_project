package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Shape;
import org.junit.jupiter.api.Test;

import javafx.scene.paint.Color;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class DrawablePolygonTest {
    @Test
    void testDraw(){
        DrawablePolygon poly = new DrawablePolygon();

        assertInstanceOf(Shape.class, poly.draw(0.0, 0.0, 2.0, 3.0, Color.BLACK, Color.YELLOW, "Unused string"));
        assertNotEquals(Color.YELLOW, poly.draw(0.0, 0.0, 2.0, 3.0, Color.BLACK, Color.YELLOW,"Unused string").getFill());
        assertEquals(Color.BLACK, poly.draw(0.0, 0.0, 2.0, 3.0, Color.BLACK, Color.YELLOW, "Unused string").getFill());

        assertInstanceOf(Shape.class, poly.draw(0.0, 5.0, 2.0, 3.0, Color.BLACK, Color.YELLOW, "Unused string"));
        assertNotEquals(Color.YELLOW, poly.draw(0.0, 5.0, 2.0, 3.0, Color.BLACK, Color.YELLOW, "Unused string").getFill());
        assertEquals(Color.BLACK, poly.draw(0.0, 5.0, 2.0, 3.0, Color.BLACK, Color.YELLOW, "Unused string").getFill());

        assertInstanceOf(Shape.class, poly.draw(5.0, 5.0, 2.0, 3.0, Color.BLACK, Color.YELLOW, "Unused string"));
        assertNotEquals(Color.YELLOW, poly.draw(5.0, 5.0, 2.0, 3.0, Color.BLACK, Color.YELLOW, "Unused string").getFill());
        assertEquals(Color.BLACK, poly.draw(5.0, 5.0, 2.0, 3.0, Color.BLACK, Color.YELLOW, "Unused string").getFill());
        //i due assert finali serve per verificare che non sia una shape chiusa
        //verificando la non esecuzione della setFill (con colore YELLOW)
        //essendo impostato il valore di default (con colore BLACK)
    }
    @Test
    void testClosureDraw(){
        DrawablePolygon poly = new DrawablePolygon();

        poly.draw(0.0, 0.0, 2.0, 3.0, Color.BLACK, Color.YELLOW, "Unused string");
        poly.draw(0.0, 5.0, 2.0, 3.0, Color.BLACK, Color.YELLOW, "Unused string");
        poly.draw(5.0, 5.0, 2.0, 3.0, Color.BLACK, Color.YELLOW, "Unused string");

        assertInstanceOf(Shape.class, poly.closureDraw(Color.BLACK, Color.YELLOW));
        assertEquals(Color.YELLOW, poly.closureDraw(Color.BLACK, Color.YELLOW).getFill());

    }

}