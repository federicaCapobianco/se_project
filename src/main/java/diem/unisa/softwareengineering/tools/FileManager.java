package diem.unisa.softwareengineering.tools;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.beans.DefaultPersistenceDelegate;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileManager {
    private Pane canvas;

    public FileManager(Pane canvas) {
        this.canvas = canvas;
    }


    public File saveFile(File file) throws IOException {
        try (XMLEncoder encoder = new XMLEncoder(
                new BufferedOutputStream(
                        Files.newOutputStream(file.toPath())))) {

            encoder.setExceptionListener(e -> {
                throw new RuntimeException(e);
            });

            encoder.setPersistenceDelegate(Color.class, new DefaultPersistenceDelegate(new String[]{"red", "green", "blue", "opacity"}));
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
