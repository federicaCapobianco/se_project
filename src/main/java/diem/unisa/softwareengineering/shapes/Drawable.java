package diem.unisa.softwareengineering.shapes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.List;

/**
 * The drawable interface is necessary to make all the drawable shapes implement the draw method.
 */
public interface Drawable {
    public Shape draw(double xS, double yS, double xE, double yE, Color lineColor, Color fillColor, String text) ;

}
