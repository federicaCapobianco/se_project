package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class DrawableLine extends Shape implements Drawable{

    @Override
    public Shape draw(double xS, double yS, double xE, double yE) {
        Line line = new Line(xS, yS, xE, yE);
        return line;

    }
}
