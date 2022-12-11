package diem.unisa.softwareengineering.tools;

import javafx.scene.layout.Pane;
import javafx.scene.transform.Scale;

/**
 * A class that allows to zoom in and out the canva.
 */
public class Zoom {
    Pane drawingPane;

    Double plusValue = 1.1;
    Double minusValue = 0.9;


    public Zoom(Pane drawingPane) {
        this.drawingPane = drawingPane;
    }

    public void zoomPlus(){
        Scale scale = new Scale();
        scale.setX(drawingPane.getScaleX() * plusValue);
        scale.setY(drawingPane.getScaleY() * plusValue);
        scale.setPivotX(0);
        scale.setPivotY(0);
        drawingPane.getTransforms().add(scale);
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
        drawingPane.setPrefWidth(drawingPane.getPrefWidth() * minusValue);
        drawingPane.setPrefHeight(drawingPane.getPrefHeight() * minusValue);
    }

}
