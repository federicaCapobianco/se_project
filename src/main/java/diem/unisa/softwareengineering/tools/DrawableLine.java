package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class DrawableLine extends DrawableShape implements Drawable{
    private Shape line;
    @Override
    public Shape draw(double xS, double yS, double xE, double yE) {
        this.line = new Line(xS, yS, xE, yE);
        return line;
    }
}
