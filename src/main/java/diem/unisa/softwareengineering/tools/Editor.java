package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.Stack;

/**
 * A class that allows to save the reference to all the right clicked(selected) nodes on the canva seen as shapes.
 */
public class  Editor {
    private Shape selectedNodes;

    private Command c; //se ho lo stack qui a che serve il reference c? DA RIVEDERE

    private Stack<Command> commandStack = new Stack<Command>();

    public Shape getSelectedNode() {
        return selectedNodes;
    }

    public void addSelectedNode(Shape selectedNode) {
        this.selectedNodes = selectedNode;
        //add a new node to the array selectedNode
    }

    public void clearSelectedNode(){
        this.selectedNodes = null;
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

}
