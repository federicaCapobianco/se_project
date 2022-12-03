package diem.unisa.softwareengineering.tools;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * A class that allows to save the reference to a right clicked(selected) node on the canva seen as shapes.
 * Editor also handles copy and paste operations.
 */

public class  Editor {

    private Shape selectedNode;

    private Command c;

    private Stack<Command> commandStack = new Stack<Command>();
    

    public Shape getSelectedNode() {
        return selectedNode;
    }

    public void addSelectedNode(Shape selectedNode) {
        this.selectedNode = selectedNode;
    }

    public void clearSelectedNode(){
        this.selectedNode = null;
    }


    public void selectShape(Node shape, DropShadow dropShadow){
        if(this.getSelectedNode() != null) {
            this.getSelectedNode().setEffect(null);
            this.clearSelectedNode();
        }

        if(shape instanceof Shape) {
            shape.setEffect(null);
            this.addSelectedNode((Shape) shape);
            this.getSelectedNode().setEffect(dropShadow);
        }
        //if target is Pane don't select anything
        else if(shape instanceof Pane) {
            this.clearSelectedNode();
        }
    }

    public void deselectShape(Node shape){
        shape.setEffect(null);
        this.clearSelectedNode();
    }

    public void setCommand(Command c) {
        this.c = c;
    }

    public void executeCommand(Command c) {
        commandStack.push(c);
        c.execute();
    }

    public void undoCommand() {
        Command c = commandStack.pop();
        c.undo();
    }

    public Stack<Command> getCommandStack() {
        return commandStack;
    }
}
