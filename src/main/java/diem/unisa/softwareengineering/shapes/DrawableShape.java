package diem.unisa.softwareengineering.shapes;

import diem.unisa.softwareengineering.shapes.Drawable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 * The DrawableShape class is necessary to make all the drawable shapes extend the draw method.
 */
public abstract class DrawableShape implements Drawable {
    public abstract Shape draw(double xS, double yS, double xE, double yE, Color lineColor, Color fillColor, String text);

}
