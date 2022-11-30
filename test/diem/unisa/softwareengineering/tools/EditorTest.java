package diem.unisa.softwareengineering.tools;


import javafx.scene.input.Clipboard;
import javafx.scene.input.DataFormat;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class EditorTest {
    @Test
    void testGetSelectedNodes() {
        Editor editor = new Editor();
        Shape shape = new Line();
        editor.addSelectedNode(shape);
        assertInstanceOf(Shape.class, editor.getSelectedNode());
    }

    @Test
    void testAddSelectedNode() {
        Editor editor = new Editor();
        Shape shape = new Line();
        editor.addSelectedNode(shape);
        assertEquals(shape, editor.getSelectedNode());
    }

    @Test
    void testClearSelectedNode() {
        Editor editor = new Editor();
        Shape shape = new Line();
        editor.addSelectedNode(shape);
        editor.clearSelectedNode();
        assertNull(editor.getSelectedNode());
    }

    @Test
    void testSelectShape() {
        Editor editor = new Editor();
        Shape shape = new Line();
        editor.selectShape(shape, null);
        assertEquals(shape, editor.getSelectedNode());
    }

    @Test
    void testDeselectShape() {
        Editor editor = new Editor();
        Shape shape = new Line();
        editor.selectShape(shape, null);
        editor.deselectShape(shape);
        assertNull(editor.getSelectedNode());
    }

    /*
    @Test
    void testCopyShape() {
        Editor editor = new Editor();
        Shape shape = new Line();
        Pane canva = new Pane();
        //create a new clipboard

        canva.getChildren().add(shape);

        editor.selectShape(shape, null);
        editor.copyShape(editor.getSelectedNode());

        Shape copiedShape = editor.pasteShape(canva,0,0);
        assertEquals(shape, copiedShape);
    }
*/
    @Test
    void testExecuteCommand() {
        //Crea uno stack vuoto
        //Crea un editor
        //Crea un comando
        //Esegui il comando
        //Verifica che lo stack non sia vuoto
        //Verifica che lo stack abbia un elemento
        //Verifica che lo stack abbia il comando che hai creato
       // Stack<Command> commandStack = new Stack<Command>();
        Editor editor = new Editor();
        Shape shape = new Line(10,15,20,35);
        Pane p = new Pane();
        Command cmd = new DeleteCommand( shape, p );
        editor.executeCommand(cmd);
        assertFalse(editor.getCommandStack().isEmpty());
    }

    @Test
    void testUnduCommand() {
        Editor editor = new Editor();
        Shape shape = new Line(10,15,20,35);
        Pane p = new Pane();
        Command cmd = new DeleteCommand( shape, p );
        editor.executeCommand(cmd);
        editor.undoCommand();
        assertTrue(editor.getCommandStack().isEmpty());
    }

    @Test
    void testGetCommandStack() {
        Editor editor = new Editor();
        assertInstanceOf(Stack.class, editor.getCommandStack());
    }

}