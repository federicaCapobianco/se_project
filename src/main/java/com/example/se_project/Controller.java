package com.example.se_project;

import diem.unisa.softwareengineering.tools.*;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.*;
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
    private Label fillLabel;

    @FXML
    private Button lineButton;
    @FXML
    private Button rectangleButton;
    @FXML
    private MenuItem saveButton;
    @FXML
    private MenuItem loadButton;

    @FXML
    private ColorPicker lineColorPicker;

    @FXML
    private ColorPicker fillColorPicker;

    @FXML
    private Button ellipseButton;
    @FXML
    private Label tfLine;
    @FXML
    private Pane drawingPane;

    @FXML
    private Button plusSizeButton;

    @FXML
    private Button minusSizeButton;

    ContextMenu contextMenu = new ContextMenu();
    MenuItem deselect = new MenuItem("Deselect");
    MenuItem delete = new MenuItem("Delete");
    MenuItem copy = new MenuItem("Copy");
    MenuItem paste = new MenuItem("Paste");
    DropShadow dropShadow = new DropShadow();

    private Tools toolManager;
    private FileManager fileManager;
    private FileChooser fileChooser;
    private Editor shapeEditor;
    private final Clipboard clipboard = Clipboard.getSystemClipboard();

    @FXML
    private ToggleButton moveToggle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toolManager = new Tools();
        fileManager = new FileManager(drawingPane);
        fileChooser = new FileChooser();
        shapeEditor = new Editor();

        toolManager.setShapeLineColor(Color.BLACK);
        toolManager.setShapeFillColor(Color.TRANSPARENT);

        lineButton.disableProperty().bind(moveToggle.selectedProperty());
        rectangleButton.disableProperty().bind(moveToggle.selectedProperty());
        ellipseButton.disableProperty().bind(moveToggle.selectedProperty());
    }

    @FXML
    private void setLine(ActionEvent actionEvent) {
        toolManager.changeState(new DrawableLine());
    }

    @FXML
    private void setEllipse(ActionEvent actionEvent) {
        toolManager.changeState(new DrawableEllipse());
    }

    @FXML
    public void setRectangle(ActionEvent actionEvent) {
        toolManager.changeState(new DrawableRectangle());
    }

    double selectionPointX;
    double selectionPointY;


    @FXML
    public void mouseDown(MouseEvent mouseEvent) {

            if (mouseEvent.getButton() == MouseButton.SECONDARY) {

                selectionPointX = mouseEvent.getX();
                selectionPointY = mouseEvent.getY();
                Node target = (Node) mouseEvent.getTarget();

                shapeEditor.selectShape((Node) target, dropShadow);

                contextMenu.getItems().addAll(deselect, delete, copy, paste);
                contextMenu.show(drawingPane, mouseEvent.getScreenX(), mouseEvent.getScreenY());

                dropShadow.setRadius(5.0);
                dropShadow.setOffsetX(3.0);
                dropShadow.setOffsetY(3.0);
                dropShadow.setColor(Color.color(0.4, 0.5, 0.5));


                deselect.setOnAction((ActionEvent event) -> {
                    shapeEditor.deselectShape(target);
                });

                copy.setOnAction((ActionEvent event) -> {
                    shapeEditor.copyShape(target);
                });

                paste.setOnAction((ActionEvent event) -> {
                    shapeEditor.pasteShape(drawingPane, selectionPointX, selectionPointY);
                });

                delete.setOnAction((ActionEvent event) -> {
                    Command cmd = new DeleteCommand(shapeEditor.getSelectedNode(), drawingPane);
                    shapeEditor.executeCommand(cmd);
                });

            } else if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                contextMenu.hide();
                if(moveToggle.isSelected()){
                    Command cmd = new MoveCommand(shapeEditor.getSelectedNode(), drawingPane, mouseEvent.getX(), mouseEvent.getY());
                    shapeEditor.executeCommand(cmd);
                }
                else {
                    toolManager.setxS(mouseEvent.getX());
                    toolManager.setyS(mouseEvent.getY());
                    shapeEditor.getSelectedNode().setEffect(null);
                    shapeEditor.clearSelectedNode();
                }
            }
    }

    @FXML
    public void mouseUp(MouseEvent mouseEvent) {
        if(!moveToggle.isSelected()){
            if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            } else if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                contextMenu.hide();
                toolManager.setxE(mouseEvent.getX());
                toolManager.setyE(mouseEvent.getY());

                Shape shape = toolManager.draw();
                drawingPane.getChildren().add(shape);
            }
        }
    }

    @FXML
    public void setLineColor(ActionEvent actionEvent) {
        toolManager.setShapeLineColor(lineColorPicker.getValue());
    }

    @FXML
    public void setFillColor(ActionEvent actionEvent) {
        toolManager.setShapeFillColor(fillColorPicker.getValue());
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
                fileManager.saveFile(file);
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
                fileManager.loadFile(file);
                System.out.println(file.getName());
            }
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }


    public void setUndo(ActionEvent actionEvent) {
        shapeEditor.undoCommand();
    }
    public void setPlusSize(ActionEvent actionEvent) {
        Command cmd = new PlusSizeCommand(shapeEditor.getSelectedNode());
        shapeEditor.executeCommand(cmd);
    }

    public void setMinusSize(ActionEvent actionEvent) {
        Command cmd = new MinusSizeCommand(shapeEditor.getSelectedNode());
        shapeEditor.executeCommand(cmd);
    }

    public void setToBack(ActionEvent actionEvent) {
        Command cmd = new ToBackCommand(shapeEditor.getSelectedNode());
        shapeEditor.executeCommand(cmd);
    }
}