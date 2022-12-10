package diem.unisa.softwareengineering.tools;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;

public class Zoom {

    Pane drawingPane;
    private GridPane gridPane;

    Double plusValue = 1.1;
    Double minusValue = 0.9;


    public Zoom(Pane drawingPane, GridPane gridPane) {
        this.drawingPane = drawingPane;
        this.gridPane = gridPane;
    }

    public void zoomPlus(){
        Scale scale = new Scale();
        scale.setX(drawingPane.getScaleX() * plusValue);
        scale.setY(drawingPane.getScaleY() * plusValue);
        scale.setPivotX(0);
        scale.setPivotY(0);
        drawingPane.getTransforms().add(scale);
        //gridPane.getTransforms().add(scale);

        //add the scale transformation to all the shapes
        /*for (Node node : drawingPane.getChildren()) {
            node.getTransforms().add(scale);
        }*/

        drawingPane.setPrefWidth(drawingPane.getPrefWidth() * plusValue);
        drawingPane.setPrefHeight(drawingPane.getPrefHeight() * plusValue);


    }

    public void zoomMinus(){
        Scale scale = new Scale();
        scale.setX(drawingPane.getScaleX() * minusValue);
        scale.setY(drawingPane.getScaleY() * minusValue);
        scale.setPivotX(0);
        scale.setPivotY(0);
        drawingPane.getTransforms().add(scale);
        //gridPane.getTransforms().add(scale);

        //add the scale transformation to all the shapes
        /*for (Node node : drawingPane.getChildren()) {
            node.getTransforms().add(scale);
        }*/
        //if (test.getMxx() < 1) {
        drawingPane.setPrefWidth(drawingPane.getPrefWidth() * minusValue);
        drawingPane.setPrefHeight(drawingPane.getPrefHeight() * minusValue);
        //}
    }

}
