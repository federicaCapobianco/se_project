package diem.unisa.softwareengineering.tools;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawableRectangleTest {

    @Test
    void testDraw() {
        DrawableRectangle rect = new DrawableRectangle();

        //xS=xE && yS=yE //punto
        assertInstanceOf(Shape.class, rect.draw(4.0,2.0,4.0,2.0, Color.BLACK, Color.TRANSPARENT, "unesed text"));
        //xS=xE && yS<yE //linea verso l'alto
        assertInstanceOf(Shape.class, rect.draw(4.0,3.0,4.0,5.0, Color.BLACK, Color.TRANSPARENT, "unesed text"));
        //xS=xE && yS>yE //linea verso il basso
        assertInstanceOf(Shape.class, rect.draw(4.0,5.0,4.0,3.0, Color.BLACK, Color.TRANSPARENT, "unesed text"));
        //xS<xE && yS=yE //linea verso destra
        assertInstanceOf(Shape.class, rect.draw(3.0,2.0,5.0,2.0, Color.BLACK, Color.TRANSPARENT, "unesed text"));
        //xS>xE && yS=yE //linea verso sinistra
        assertInstanceOf(Shape.class, rect.draw(5.0,2.0,3.0,2.0, Color.BLACK, Color.TRANSPARENT, "unesed text"));

        //xS<xE && yS>yE //rettangolo verso il basso a destra
        assertInstanceOf(Shape.class, rect.draw(11.0,5.0,16.0,3.0, Color.BLACK, Color.TRANSPARENT, "unesed text"));
        //xS<xE && yS<yE //rettangolo verso l'alto a destra
        assertInstanceOf(Shape.class, rect.draw(11.0,3.0,16.0,5.0, Color.BLACK, Color.TRANSPARENT, "unesed text"));
        //xS>xE && yS>yE //rettangolo verso il basso a sinistra
        assertInstanceOf(Shape.class, rect.draw(16.0,5.0,11.0,3.0, Color.BLACK, Color.TRANSPARENT, "unesed text"));
        //xS>xE && yS<yE //rettangolo verso l'alto a sinistra
        assertInstanceOf(Shape.class, rect.draw(16.0,3.0,11.0,5.0, Color.BLACK, Color.TRANSPARENT, "unesed text"));

    }
}