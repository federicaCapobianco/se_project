package diem.unisa.softwareengineering.tools;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that allows the user to set the current tool and draw a new shape on the canva as the user drags the mouse.
 */
public class Tools {
    //add an instance of the Shape class
    private DrawableShape shape;

    private double xS,xE,yS,yE;

    private Color shapeLineColor;

    private Color shapeFillColor;


    //add a method changeState that instantiates the shape as for the passed parameter
    public void changeState(DrawableShape state){
        shape = state; //this will be line, circle, rectangle, etc.
    }

    //add a method draw that calls the draw method of the shape class
    public Shape draw(){
        return shape.draw(xS,yS,xE,yE, shapeLineColor, shapeFillColor);
    }

    public Shape closureDraw(Pane canva){
        DrawablePolygon poly = (DrawablePolygon) shape; //cast fatto per non inserire in drawableShape in metodo della closure
        return poly.closureDraw(shapeLineColor, shapeFillColor, canva);
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

    public void setShapeLineColor(Color shapeLineColor){ this.shapeLineColor = shapeLineColor; }

    public void setShapeFillColor(Color shapeFillColor){
        this.shapeFillColor = shapeFillColor;
    }

    public DrawableShape getShape(){ return shape;}

}

