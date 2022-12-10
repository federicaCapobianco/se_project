package diem.unisa.softwareengineering.tools;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;

public class Zoom {

    private Pane drawingPane;
    private GridPane gridPane;

    public Zoom(Pane drawingPane, GridPane gridPane) {
        this.drawingPane = drawingPane;
        this.gridPane = gridPane;
    }

    public void zoomPlus(){
        Scale scale = new Scale();
        scale.setX(1.1);
        scale.setY(1.1);
        scale.setPivotX(0);
        scale.setPivotY(0);
        drawingPane.getTransforms().add(scale);
        //gridPane.getTransforms().add(scale);

        //add the scale transformation to all the shapes
        for (Node node : drawingPane.getChildren()) {
            node.getTransforms().add(scale);
        }

        drawingPane.setPrefWidth(drawingPane.getPrefWidth() + 100);
        drawingPane.setPrefHeight(drawingPane.getPrefHeight() + 100);

        //gridPane.setPrefSize(drawingPane.getPrefWidth(), drawingPane.getPrefHeight());

        //gridPane.setPrefWidth(gridPane.getPrefWidth() + 100);
        //gridPane.setPrefHeight(gridPane.getPrefHeight() + 100);

        //gridPane.setPrefWidth(drawingPane.getPrefWidth());
        //gridPane.setPrefHeight(drawingPane.getPrefHeight());
    }

    public void zoomMinus(){
        Scale scale = new Scale();
        scale.setX(0.9);
        scale.setY(0.9);
        scale.setPivotX(0);
        scale.setPivotY(0);
        drawingPane.getTransforms().add(scale);
        //gridPane.getTransforms().add(scale);

        //add the scale transformation to all the shapes
        for (Node node : drawingPane.getChildren()) {
            node.getTransforms().add(scale);
        }

        Transform test = drawingPane.getTransforms().get(0);
        if (test.getMxx() > 1) {
            drawingPane.setPrefWidth(drawingPane.getPrefWidth() - 100);
            drawingPane.setPrefHeight(drawingPane.getPrefHeight() - 100);
        }

        /*Transform test2 = gridPane.getTransforms().get(0);
        if (test2.getMxx() > 1) {
            gridPane.setPrefWidth(gridPane.getPrefWidth() - 100);
            gridPane.setPrefHeight(gridPane.getPrefHeight() - 100);
        }*/
        //gridPane.setPrefSize(drawingPane.getPrefWidth(), drawingPane.getPrefHeight());

        //imposta la dimensione del pane uguale a quello della griglia
        //gridPane.setPrefWidth(drawingPane.getPrefWidth());
        //gridPane.setPrefHeight(drawingPane.getPrefHeight());
    }

}
