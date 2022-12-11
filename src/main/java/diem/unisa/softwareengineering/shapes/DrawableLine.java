package diem.unisa.softwareengineering.shapes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

/**
 * The DrawableLine class is used to draw a line on the canvas. It implements the Drawable interface.
 */
public class DrawableLine extends DrawableShape {
    private Shape line;

    @Override
    public Shape draw(double xS, double yS, double xE, double yE, Color lineColor, Color fillColor, String text) {
        this.line = new Line(xS, yS, xE, yE);
        this.line.setStroke(lineColor);
        return line;
    }
}
