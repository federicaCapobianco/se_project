package diem.unisa.softwareengineering.shapes;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;


import static java.lang.Math.abs;

/**
 * The DrawableEllipse class is used to draw an ellipse, it implements the Drawable interface.
 */
public class DrawableEllipse extends DrawableShape {

    private Shape ellipse;

    @Override
    public Shape draw(double xS, double yS, double xE, double yE, Color lineColor, Color fillColor, String text) {
        this.ellipse = new Ellipse(xS+(xE-xS)/2, yE+(yS-yE)/2, abs(xS-xE)/2, abs(yS-yE)/2); //xS, yS, xE, yE
        this.ellipse.setStroke(lineColor);
        this.ellipse.setFill(fillColor);
        return ellipse;
    }
}
