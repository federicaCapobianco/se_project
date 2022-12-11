package diem.unisa.softwareengineering.tools;

import diem.unisa.softwareengineering.commands.Command;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

import java.util.Stack;


/**
 * A class that allows to save the reference to a right clicked(selected) node on the canva seen as shapes.
 * Editor also handles copy and paste and other operations.
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
        if(!commandStack.isEmpty()) {
            Command c = commandStack.pop();
            c.undo();
        }
    }

    public Stack<Command> getCommandStack() {
        return commandStack;
    }
}
