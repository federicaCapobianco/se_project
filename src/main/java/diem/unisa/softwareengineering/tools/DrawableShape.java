package diem.unisa.softwareengineering.tools;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public abstract class DrawableShape implements Drawable {
    //public abstract Shape draw(double xS, double yS, double xE, double yE);
    private Shape shape;
    public DrawableShape(){}

    public DrawableShape(Shape shape){
        this.shape = shape;
    }
    public abstract Shape draw(double xS, double yS, double xE, double yE, Color lineColor, Color fillColor);
}
