package diem.unisa.softwareengineering.tools;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class CustomClipboardTest {

        @Test
        void testCopy() {
            CustomClipboard customClipboard = new CustomClipboard();
            customClipboard.copy(new Line());
            assertTrue(new File("copy.xml").exists());
        }

        @Test
        void testPaste() {
            CustomClipboard customClipboard = new CustomClipboard();
            Pane drawingPane = new Pane();
            customClipboard.copy(new Line());
            Shape shape = customClipboard.paste(drawingPane, 0, 0);
            assertEquals(1, drawingPane.getChildren().size());
            assertEquals(shape, drawingPane.getChildren().get(0));
        }
}