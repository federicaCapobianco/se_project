package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.Stack;

/**
 * A class that allows to save the reference to all the right clicked(selected) nodes on the canva seen as shapes.
 */
public class  Editor {
    private ArrayList<Shape> selectedNodes = new ArrayList<Shape>();

    private Command c; //se ho lo stack qui a che serve il reference c? DA RIVEDERE

    private Stack<Command> commandStack = new Stack<Command>();

    public ArrayList<Shape> getSelectedNodes() {
        return selectedNodes;
    }

    public void addSelectedNode(Shape selectedNode) {
        this.selectedNodes.add(selectedNode);
        //add a new node to the array selectedNode
    }
    public ArrayList<Shape> removeSelectedNode(Shape selectedNode) {
        this.selectedNodes.remove(selectedNode);
        return selectedNodes;
        //remove all the nodes from the array selectedNode
    }

    public void clearSelectedNodes(){
        this.selectedNodes.clear();
    }

    public void setCommand() { }

    public void executeCommand() { }

    public void unduCommand() { }

}
