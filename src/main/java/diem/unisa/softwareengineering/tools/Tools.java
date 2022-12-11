package diem.unisa.softwareengineering.tools;

import diem.unisa.softwareengineering.shapes.DrawablePolygon;
import diem.unisa.softwareengineering.shapes.DrawableShape;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 * A class that allows the user to set the current tool and draw a new shape on the canva as the user drags the mouse.
 * It is based on the Command design pattern.
 */
public class Tools {
    private DrawableShape shape;

    private double xS,xE,yS,yE;

    private Color shapeLineColor;

    private Color shapeFillColor;

    private String textString;

    public void changeState(DrawableShape state){
        shape = state;

    }

    public Shape draw(){
       return shape.draw(xS,yS,xE,yE,shapeLineColor, shapeFillColor, textString);
    }

    public Shape closureDraw(){
        DrawablePolygon poly = (DrawablePolygon) shape;
        return poly.closureDraw(shapeLineColor, shapeFillColor);
    }

    public double getxS() {
        return xS;
    }

    public double getxE() {
        return xE;
    }

    public double getyS() {
        return yS;
    }

    public double getyE() {
        return yE;
    }

    public Color getShapeLineColor() {
        return shapeLineColor;
    }

    public Color getShapeFillColor(){
        return shapeFillColor;
    }

    public void setxS(double xS) {
        this.xS = xS;
    }

    public void setxE(double xE) {
        this.xE = xE;
    }

    public void setyS(double yS) {
        this.yS = yS;
    }

    public void setyE(double yE) {
        this.yE = yE;
    }

    public void setTextString(String textString) {
        this.textString = textString;
    }

    public void setShapeLineColor(Color shapeLineColor){ this.shapeLineColor = shapeLineColor; }

    public void setShapeFillColor(Color shapeFillColor){
        this.shapeFillColor = shapeFillColor;
    }

    public DrawableShape getShape(){ return shape;}

}

