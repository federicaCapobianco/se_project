package diem.unisa.softwareengineering.tools;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class DrawableLine extends DrawableShape implements Drawable{
    private Shape line;

    @Override
    public Shape draw(double xS, double yS, double xE, double yE, Color lineColor) {
        this.line = new Line(xS, yS, xE, yE);
        this.line.setStroke(lineColor);
        return line;
    }
}
