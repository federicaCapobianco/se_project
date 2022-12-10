package diem.unisa.softwareengineering.tools;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.List;

public interface Drawable {
    public Shape draw(double xS, double yS, double xE, double yE, Color lineColor, Color fillColor, String text) ;

}
