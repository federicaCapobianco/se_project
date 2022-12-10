package diem.unisa.softwareengineering.tools;

import javafx.scene.layout.Pane;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;

public class Zoom {
    Scale scale = new Scale();
    Pane drawingPane;

    public Zoom(Pane drawingPane) {
        this.drawingPane = drawingPane;
    }

    public void zoomPlus(){
        scale.setX(drawingPane.getScaleX() + 0.1);
        scale.setY(drawingPane.getScaleY() + 0.1);
        scale.setPivotX(0);
        scale.setPivotY(0);
        //add the scale transformation to all the shapes
        /*for (Node node : drawingPane.getChildren()) {
            node.getTransforms().add(scale);
        }*/
        //Transform test = drawingPane.getTransforms().get(0);
        drawingPane.getTransforms().add(scale);
        drawingPane.setPrefWidth(drawingPane.getPrefWidth() + 100);
        drawingPane.setPrefHeight(drawingPane.getPrefHeight() + 100);

        //return scale;
    }
}
