package com.example.se_project;

import diem.unisa.softwareengineering.tools.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;



public class Controller {
    private Context c = new Context();

    @FXML
    private Pane paneID;

    @FXML
    private Button lineButton;


    @FXML
    private void setLine(ActionEvent actionEvent) {
      //  c.changeState(new DrawableLine());
    }
    @FXML
    private void mouseDown (MouseEvent mouseEvent){
        c.setxS(mouseEvent.getX());
        c.setyS(mouseEvent.getY());
    }
    @FXML
    private void mouseUp (MouseEvent mouseEvent){
        c.setxE(mouseEvent.getX());
        c.setyE(mouseEvent.getY());
    }

}