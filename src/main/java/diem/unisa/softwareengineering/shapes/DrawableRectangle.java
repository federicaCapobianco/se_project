package diem.unisa.softwareengineering.shapes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import static java.lang.Math.abs;

/**
 * The DrawableRectangle class is used to draw a rectangle, it implements the Drawable interface.
 */
public class DrawableRectangle extends DrawableShape {
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
