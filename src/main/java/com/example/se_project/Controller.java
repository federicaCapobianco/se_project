package com.example.se_project;

import diem.unisa.softwareengineering.tools.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
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
    private MenuItem saveButton;
    @FXML
    private MenuItem loadButton;

    @FXML
    private void setLine(ActionEvent actionEvent) {
         c.changeState(new DrawableLine());
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

    @FXML
    public void saveFile(ActionEvent actionEvent) {
    }

    @FXML
    public void loadFile(ActionEvent actionEvent) {
    }
}