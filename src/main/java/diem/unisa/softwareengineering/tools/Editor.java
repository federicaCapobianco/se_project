package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.Stack;

/**
 * A class that allows to save the reference to all the right clicked(selected) nodes on the canva seen as shapes.
 */
public class  Editor {
    private ArrayList<Shape> selectedNodes = new ArrayList<Shape>();

    private Shape figSelezionata;

    private Command c; //se ho lo stack qui a che serve il reference c? DA RIVEDERE

    private Stack<Command> commandStack = new Stack<Command>();

    public ArrayList<Shape> getSelectedNodes() {
        return selectedNodes;
    }
    public Shape getSelectedFigura(){   ///////////////////////////////////////
        return figSelezionata;
    }

    public void addSelectedNode(Shape selectedNode) {
        this.selectedNodes.add(selectedNode);
        //add a new node to the array selectedNode
    }

    public void addSelectedFigura(Shape selectedNode) {     /////////////////////////////////////////
        this.figSelezionata = selectedNode;
        //add a new node to the array selectedNode
    }

    public ArrayList<Shape> removeSelectedNode(Shape selectedNode) {
        selectedNodes.remove(selectedNode);
        return selectedNodes;
        //remove all the nodes from the array selectedNode
    }

    public void clearSelectedNodes(){
        this.selectedNodes.clear();
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
