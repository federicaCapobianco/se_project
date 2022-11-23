package com.example.se_project;

import diem.unisa.softwareengineering.tools.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;



public class Controller {
    private Context c = new Context();

    @FXML
    private Button lineButton;
    @FXML
    private Pane drawingPane;
    @FXML
    private Button rectangleButton;

    @FXML
    private void setLine(ActionEvent actionEvent) {
        c.changeState(new DrawableLine());
    }

    @FXML
    public void setRectangle(ActionEvent actionEvent) {
        c.changeState(new DrawableRectangle());
    }

    @FXML
    public void mouseDown(MouseEvent mouseEvent) {
        c.setxS(mouseEvent.getX());
        c.setyS(mouseEvent.getY());
    }

    @FXML
    public void mouseUp(MouseEvent mouseEvent) {
        c.setxE(mouseEvent.getX());
        c.setyE(mouseEvent.getY());

        Shape shape = c.draw();
        drawingPane.getChildren().add(shape);
    }


}