package diem.unisa.softwareengineering.tools;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.List;

public abstract class DrawableShape implements Drawable {

    public abstract Shape draw(double xS, double yS, double xE, double yE, Color lineColor, Color fillColor, String text);

}
