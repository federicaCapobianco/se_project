package diem.unisa.softwareengineering.tools;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.List;

import static java.lang.Math.abs;

public class DrawableRectangle extends DrawableShape{
    private Shape rectangle;

    @Override
    public Shape draw(double xS, double yS, double xE, double yE, Color lineColor, Color fillColor, String text){
        if(xS>xE){
            if(yS<yE){
                this.rectangle = new Rectangle(xE, yS, abs(xS-abs(xE)), abs(yS-abs(yE)));
            }else{
                this.rectangle = new Rectangle(xE, yE, abs(xS-abs(xE)), abs(yE-abs(yS)));}
        } else if (yS<yE) {
            this.rectangle = new Rectangle(xS, yS, abs(xE-abs(xS)), abs(yS-abs(yE)));
        }
        else{
            this.rectangle = new Rectangle(xS, yE, abs(xE-abs(xS)), abs(yE-abs(yS)));
        }

        this.rectangle.setStroke(lineColor);
        this.rectangle.setFill(fillColor);
        return rectangle;
    }
}
