package diem.unisa.softwareengineering.tools;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
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

    public DrawableShape getShape(){ return shape;}

    //add a method changeState that instantiates the shape as for the passed parameter
    public void changeState(DrawableShape state){
        shape = state; //this will be line, circle, rectangle, etc.
    }

    //add a method draw that calls the draw method of the shape class
    public Shape draw(){
        return shape.draw(xS,yS,xE,yE);
    }

    private static void addPersistenceDelegatesTo(Encoder encoder) {
        encoder.setPersistenceDelegate(Font.class,
                new DefaultPersistenceDelegate(
                        new String[] { "name", "size" }));
        encoder.setPersistenceDelegate(Color.class,
                new DefaultPersistenceDelegate(
                        new String[] { "red", "green", "blue", " black","white","transparent", "opacity" }));
        encoder.setPersistenceDelegate(LinearGradient.class,
                new DefaultPersistenceDelegate(new String[] {
                        "startX", "startY", "endX", "endY",
                        "proportional", "cycleMethod", "stops"
                }));
        encoder.setPersistenceDelegate(RadialGradient.class,
                new DefaultPersistenceDelegate(new String[] {
                        "focusAngle", "focusDistance", "centerX", "centerY",
                        "radius", "proportional", "cycleMethod", "stops"
                }));
    }

    public File saveFile(Pane pane, File file) throws IOException {
        try (XMLEncoder encoder = new XMLEncoder(
                new BufferedOutputStream(
                        Files.newOutputStream(file.toPath())))) {

            encoder.setExceptionListener(e -> {
                throw new RuntimeException(e);
            });

            addPersistenceDelegatesTo(encoder);

            encoder.writeObject(pane.getChildren().toArray(new Node[0]));
            return file;
        }
    }

    public File loadFile(Pane pane, File file) throws IOException {
        try (XMLDecoder decoder = new XMLDecoder(
                new BufferedInputStream(
                        Files.newInputStream(file.toPath())))) {

            decoder.setExceptionListener(e -> {
                throw new RuntimeException(e);
            });
            pane.getChildren().setAll((Node[]) decoder.readObject());
        }
        return file;
    }
}
