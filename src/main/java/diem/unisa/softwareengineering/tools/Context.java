package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Shape;

public class Context {
    //add an instance of the Shape class
    private Shape shape;

    private double xS,xE,yS,yE;

    //add an initializer for the Context class
    public Context() {
       // shape = new DrawableLine(); //default shape is our line class



    }

    //add a method changeState that instantiates the shape as for the passed parameter
    public void changeState(Shape state){
       shape = state; //this will be line, circle, rectangle, etc.

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
}
