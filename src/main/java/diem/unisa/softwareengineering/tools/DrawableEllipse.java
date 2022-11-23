package diem.unisa.softwareengineering.tools;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

import static java.lang.Math.abs;

public class DrawableEllipse extends DrawableShape implements Drawable{

    private Shape ellipse;
    @Override
    public Shape draw(double xS, double yS, double xE, double yE) {
        this.ellipse = new Ellipse(xS, yS, abs(xS-xE), abs(yS-yE)); //xS, yS, xE, yE
        return ellipse;
    }
}
