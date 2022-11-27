package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Line;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EditorTest {

    @Test
    void testGetSelectedNodes() {
        Editor editor = new Editor();
        assertInstanceOf(ArrayList.class, editor.getSelectedNodes());
    }

    @Test
    void testAddSelectedNode() {
        Editor editor = new Editor();
        editor.addSelectedNode(new Line());
        assertEquals(1, editor.getSelectedNodes().size());
    }

    @Test
    void testRemoveSelectedNode() {
        Editor editor = new Editor();
        Line line = new Line();
        editor.removeSelectedNode(line);
        assertEquals(0, editor.getSelectedNodes().size());
    }

    @Test
    void testClearSelectedNodes() {
        Editor editor = new Editor();
        editor.addSelectedNode(new Line());
        editor.clearSelectedNodes();
        assertEquals(0, editor.getSelectedNodes().size());
    }
}