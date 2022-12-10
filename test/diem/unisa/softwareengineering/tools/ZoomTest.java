package diem.unisa.softwareengineering.tools;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZoomTest {

    @Test
    void testZoomPlus() {
        Pane drawingPane = new Pane();
        GridPane gridPane = new GridPane();
        Zoom zoom = new Zoom(drawingPane, gridPane);
        double width = drawingPane.getPrefWidth();
        double height = drawingPane.getPrefHeight();
        zoom.zoomPlus();
        assertNotEquals(width, drawingPane.getPrefWidth());
        assertNotEquals(height, drawingPane.getPrefHeight());
        assertEquals(width * 1.1, drawingPane.getPrefWidth());
        assertEquals(height * 1.1, drawingPane.getPrefHeight());
    }

    @Test
    void testZoomMinus() {
        Pane drawingPane = new Pane();
        GridPane gridPane = new GridPane();
        Zoom zoom = new Zoom(drawingPane, gridPane);
        double width = drawingPane.getPrefWidth();
        double height = drawingPane.getPrefHeight();
        zoom.zoomMinus();
        //assertNotEquals(width, drawingPane.getPrefWidth());
        //assertNotEquals(height, drawingPane.getPrefHeight());
        //stampa drawingPane.getPrefWidth()
        assertEquals(width * 0.9, drawingPane.getPrefWidth());
        assertEquals(height * 0.9, drawingPane.getPrefHeight());
    }
}