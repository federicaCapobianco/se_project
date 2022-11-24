package diem.unisa.softwareengineering.tools;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    @Test
    void testSaveFile() {
        File f = new File("test.pdf");
        File retFile = new File("/");

        Pane pane = new Pane();
        Line l = new Line(0, 0, 100, 100);
        pane.getChildren().add(l);

        Rectangle r = new Rectangle(0, 0, 100, 100);
        pane.getChildren().add(r);

        Ellipse e = new Ellipse(0, 0, 100, 100);
        pane.getChildren().add(e);

        FileManager handler = new FileManager(pane);

        try {
            retFile = assertInstanceOf(File.class, handler.saveFile(f));
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {
            assertEquals(retFile, handler.loadFile(retFile));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Test
    void testLoadFile(){

        File f = new File("test.pdf");
        File retFile = new File("/");

        Pane pane = new Pane();
        Line l = new Line(0, 0, 100, 100);
        pane.getChildren().add(l);

        Rectangle r = new Rectangle(0, 0, 100, 100);
        pane.getChildren().add(r);

        Ellipse e = new Ellipse(0, 0, 100, 100);
        pane.getChildren().add(e);

        FileManager handler = new FileManager(pane);

        try{
            handler.saveFile(f);
        }catch (IOException e1){
            e1.printStackTrace();
        }

        try {
            assertInstanceOf(File.class, handler.loadFile(f));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}