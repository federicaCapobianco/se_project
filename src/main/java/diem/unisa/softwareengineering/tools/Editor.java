package diem.unisa.softwareengineering.tools;

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

    public void copyShape(Node shape){
        Clipboard clipboard = Clipboard.getSystemClipboard();
        File file = new File("copy.xml");
        shape.setEffect(null);
        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(Files.newOutputStream(file.toPath())))) {
            encoder.setPersistenceDelegate(Color.class, new DefaultPersistenceDelegate(new String[]{"red", "green", "blue", "opacity"}));
            encoder.writeObject(shape);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ClipboardContent content = new ClipboardContent();
        List<File> files = List.of(file);
        content.putFiles(files);

        clipboard.setContent(content);
    }

    public Shape pasteShape(Pane drawingPane, double selectionPointX, double selectionPointY){
        Clipboard clipboard = Clipboard.getSystemClipboard();
        List<File> files = clipboard.getFiles();
        try (XMLDecoder decoder = new XMLDecoder(
                new BufferedInputStream(
                        Files.newInputStream(files.get(0).toPath())))) {

            decoder.setExceptionListener(e -> {
                throw new RuntimeException(e);
            });

            Shape nodeToAdd = (Shape) decoder.readObject();

            nodeToAdd.relocate(selectionPointX, selectionPointY);
            System.out.println("node: "+nodeToAdd+"x: "+nodeToAdd.getTranslateX()+" y: "+nodeToAdd.getTranslateY());
            drawingPane.getChildren().add(nodeToAdd);
            return nodeToAdd;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setCommand(Command c) {
        this.c = c;
    }

    public void executeCommand(Command c) {
        commandStack.push(c);
        c.execute();
    }

    public void unduCommand() {
        Command c = commandStack.pop();
        c.undo();
    }

}
