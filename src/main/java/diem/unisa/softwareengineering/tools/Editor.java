package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class Editor {
    private ArrayList<Shape> selectedNodes = new ArrayList<Shape>();

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
}
