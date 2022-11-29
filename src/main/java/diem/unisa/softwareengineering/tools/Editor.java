package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.Stack;

/**
 * A class that allows to save the reference to all the right clicked(selected) nodes on the canva seen as shapes.
 */
public class  Editor {
    private Shape selectedNode;

    private Command c; //se ho lo stack qui a che serve il reference c? DA RIVEDERE

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
