package com.example.se_project;

import diem.unisa.softwareengineering.tools.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {


    @FXML
    private TextField tfline;

    @FXML
    private Button lineButton;
    @FXML
    private Pane drawingPane;
    @FXML
    private Button rectangleButton;
    @FXML
    private MenuItem saveButton;
    @FXML
    private MenuItem loadButton;


    @FXML
    private ColorPicker lineColorPicker;

    private Context c;
    private FileManager fm;
    private FileChooser fileChooser;


    @FXML
    private void setLine(ActionEvent actionEvent) {
        c.changeState(new DrawableLine());
    }

    @FXML
    private void setEllipse(ActionEvent actionEvent) {
        c.changeState(new DrawableEllipse());
    }

    @FXML
    public void setRectangle(ActionEvent actionEvent) {
        c.changeState(new DrawableRectangle());
    }

    @FXML
    public void mouseDown(MouseEvent mouseEvent) {
        c.setxS(mouseEvent.getX());
        c.setyS(mouseEvent.getY());
        //could draw a temporary shape here
    }

    @FXML
    public void mouseUp(MouseEvent mouseEvent) {
        c.setxE(mouseEvent.getX());
        c.setyE(mouseEvent.getY());

        Shape shape = c.draw();
        drawingPane.getChildren().add(shape);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        c = new Context();
        fm = new FileManager(drawingPane);
        fileChooser = new FileChooser();
        c.setShapeLineColor(Color.BLACK);
    }

    @FXML
    public void saveFile(ActionEvent actionEvent) {
        Window stage = drawingPane.getScene().getWindow();
        fileChooser.setTitle("Save file");
        fileChooser.setInitialFileName("drawing");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XML Files", "*.xml"));

        try {
            File file = fileChooser.showSaveDialog(stage);
            if (file != null) {
                fm.saveFile(file);
                System.out.println(file.getName());
            }
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    @FXML
    public void loadFile(ActionEvent actionEvent) {
        Window stage = drawingPane.getScene().getWindow();
        fileChooser.setTitle("Save file");
        fileChooser.setInitialFileName("drawing");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XML Files", "*.xml"));

        try {
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                fm.loadFile(file);
                System.out.println(file.getName());
            }
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void setColorLine(ActionEvent actionEvent) {
        c.setShapeLineColor(lineColorPicker.getValue());
    }
}