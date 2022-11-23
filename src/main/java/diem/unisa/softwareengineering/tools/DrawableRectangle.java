package diem.unisa.softwareengineering.tools;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import static java.lang.Math.abs;

public class DrawableRectangle extends DrawableShape implements Drawable{
    private Shape rectangle;

    @Override
    public Shape draw(double xS, double yS, double xE, double yE){
        // le y ragionano in logica negata nel pane
        if(xS>xE){
            if(yS<yE){
                //verso il basso a sinistra
                this.rectangle = new Rectangle(xE, yS, abs(xS-abs(xE)), abs(yS-abs(yE)));
            }else{
                //verso l'alto a sinistra
                this.rectangle = new Rectangle(xE, yE, abs(xS-abs(xE)), abs(yE-abs(yS)));}
        } else if (yS<yE) {
            //verso il basso a destra
            this.rectangle = new Rectangle(xS, yS, abs(xE-abs(xS)), abs(yS-abs(yE)));
        }
        else{
            //verso l'alto a destra
            this.rectangle = new Rectangle(xS, yE, abs(xE-abs(xS)), abs(yE-abs(yS)));
        }

        this.rectangle.setStroke(Color.BLACK);
        this.rectangle.setFill(Color.TRANSPARENT);
        return rectangle;
    }
}
