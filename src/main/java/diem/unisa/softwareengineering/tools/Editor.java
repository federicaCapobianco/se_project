package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Shape;

import java.util.ArrayList;

/**
 * A class that allows to save the reference to all the right clicked(selected) nodes on the canva seen as shapes.
 */
public class Editor {
    private Shape selectedNode;

    public Shape getSelectedNode() {
        return selectedNode;
    }

    public void addSelectedNode(Shape selectedNode) {
        this.selectedNode = selectedNode;
        //add a new node to the array selectedNode
    }

    public void clearSelectedNode(){
        this.selectedNode = null;
    }
}
