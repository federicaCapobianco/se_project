package diem.unisa.softwareengineering.tools;


import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.beans.DefaultPersistenceDelegate;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * A class that saves the array of shapes located in the pane to an xml file and then retreives it.
 * The XML encoder has been properly set to accept the Color class constructor and save the color too, it might be necessary to update again.
 */
public class FileManager {
    private Pane canvas;

    public FileManager(Pane canvas) {
        this.canvas = canvas;
    }


    public File saveFile(File file) throws IOException {
        boolean containsPolygon = false;
        for (Node node : canvas.getChildren()) {
            if (node instanceof Polygon) {
                containsPolygon = true;
                break;
            }
        }
        //if it contains a polygon, launch an alert
        if (containsPolygon) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("The file contains a polygon, it will not be saved");
            a.show();
            return null;
        }

        try (XMLEncoder encoder = new XMLEncoder(
                new BufferedOutputStream(
                        Files.newOutputStream(file.toPath())))) {

            encoder.setExceptionListener(e -> {
                throw new RuntimeException(e);
            });

            encoder.setPersistenceDelegate(Color.class, new DefaultPersistenceDelegate(new String[]{"red", "green", "blue", "opacity"}));
            encoder.setPersistenceDelegate(Polygon.class, new DefaultPersistenceDelegate(new String[]{"points"}));
            encoder.setPersistenceDelegate(Text.class, new DefaultPersistenceDelegate(new String[]{"x", "y","text"}));
            encoder.setPersistenceDelegate(Font.class, new DefaultPersistenceDelegate(new String[]{"name", "size"}));
            encoder.setPersistenceDelegate(Node.class, new DefaultPersistenceDelegate(new String[]{"layoutX", "layoutY"}));

            encoder.writeObject(canvas.getChildren().toArray(new Node[0]));
            return file;
        }

    }

    public File loadFile(File file) throws IOException {
        try (XMLDecoder decoder = new XMLDecoder(
                new BufferedInputStream(
                        Files.newInputStream(file.toPath())))) {

            decoder.setExceptionListener(e -> {
                throw new RuntimeException(e);
            });

            canvas.getChildren().setAll((Node[]) decoder.readObject());
        }

        return file;
    }
}
