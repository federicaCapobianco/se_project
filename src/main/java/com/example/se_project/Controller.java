package com.example.se_project;

import diem.unisa.softwareengineering.tools.Context;
import diem.unisa.softwareengineering.tools.DrawableLine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class Controller {
    private Context c = new Context();

    @FXML
    private Pane paneID;

    @FXML
    private Button lineButton;


    @FXML
    private void setLine(ActionEvent actionEvent) {
        c.changeState(new DrawableLine());


    }

}