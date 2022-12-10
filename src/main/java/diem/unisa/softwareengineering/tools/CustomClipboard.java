package diem.unisa.softwareengineering.tools;

import javafx.scene.Node;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

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
        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(Files.newOutputStream(file.toPath())))) {
            encoder.setPersistenceDelegate(Color.class, new DefaultPersistenceDelegate(new String[]{"red", "green", "blue", "opacity"}));
            encoder.writeObject(shape);
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
            drawingPane.getChildren().add(nodeToAdd);
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
