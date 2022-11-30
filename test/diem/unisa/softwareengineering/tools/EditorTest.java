package diem.unisa.softwareengineering.tools;

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