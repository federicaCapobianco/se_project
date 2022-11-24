package diem.unisa.softwareengineering.tools;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.awt.*;
import java.beans.DefaultPersistenceDelegate;
import java.beans.Encoder;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;

import java.beans.XMLEncoder;
import java.nio.file.Files;

public class Context {
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

       return shape.draw(xS,yS,xE,yE,shapeLineColor, shapeFillColor);

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
