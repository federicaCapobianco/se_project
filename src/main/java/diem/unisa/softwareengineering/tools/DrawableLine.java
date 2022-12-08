package diem.unisa.softwareengineering.tools;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class DrawableLine extends DrawableShape{
    private Shape line;


    public DrawableLine(){ }

    @Override
    public Shape draw(double xS, double yS, double xE, double yE, Color lineColor, Color fillColor, String text) {
        this.line = new Line(xS, yS, xE, yE);
        this.line.setStroke(lineColor);
        return line;
    }
}
