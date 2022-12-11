package diem.unisa.softwareengineering.tools;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.beans.DefaultPersistenceDelegate;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class CustomClipboard {

    private Shape shape;

    public void copy(Node shape){
        File file = new File("copy.xml");
        shape.setEffect(null);

        if (shape instanceof Polygon) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("The file contains a polygon, it will not be saved");
            a.show();
            return;
        }


        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(Files.newOutputStream(file.toPath())))) {
            encoder.setPersistenceDelegate(Color.class, new DefaultPersistenceDelegate(new String[]{"red", "green", "blue", "opacity"}));
            encoder.setPersistenceDelegate(Text.class, new DefaultPersistenceDelegate(new String[]{"x", "y","text"}));

            if(shape!=null) {
                System.out.println(shape);
                encoder.writeObject(shape);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Shape paste(Pane drawingPane, double selectionPointX, double selectionPointY){
        try (XMLDecoder decoder = new XMLDecoder(
                new BufferedInputStream(
                        Files.newInputStream(new File("copy.xml").toPath())))) {

            decoder.setExceptionListener(e -> {
                throw new RuntimeException(e);
            });
            Shape nodeToAdd = (Shape) decoder.readObject();
            nodeToAdd.relocate(selectionPointX, selectionPointY);
            this.shape = nodeToAdd;
            if(nodeToAdd != null) {
                drawingPane.getChildren().add(nodeToAdd);
                return nodeToAdd;
            }
            return nodeToAdd;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Shape getShape(){
        return this.shape;
    }
}
