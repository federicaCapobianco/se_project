package diem.unisa.softwareengineering.tools;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;

import java.beans.XMLEncoder;
import java.nio.file.Files;

public class Context {
    //add an instance of the Shape class
    private DrawableShape shape;

    private double xS,xE,yS,yE;

    //add an initializer for the Context class
    public Context() {
       // shape = new DrawableLine(); //default shape is our line class



    }

    //add a method changeState that instantiates the shape as for the passed parameter
    public void changeState(DrawableShape state){
       shape = state; //this will be line, circle, rectangle, etc.
    }

    //add a method draw that calls the draw method of the shape class
    public Shape draw(){
       return shape.draw(xS,yS,xE,yE);
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

    public void saveFile(Pane pane, File file) throws IOException {
        try (XMLEncoder encoder = new XMLEncoder(
                new BufferedOutputStream(
                        Files.newOutputStream(file.toPath())))) {

            encoder.setExceptionListener(e -> {
                throw new RuntimeException(e);
            });
            encoder.writeObject(pane.getChildren().toArray(new Node[0]));
            System.out.println("File saved");
        }
    }
}
