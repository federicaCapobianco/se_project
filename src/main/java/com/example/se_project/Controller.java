package com.example.se_project;

import diem.unisa.softwareengineering.tools.*;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;
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
    private CustomClipboard clipboard;
    private GridHandler gridHandler;
    @FXML
    private ToggleButton moveToggle;
    @FXML
    private Button toFrontButton;
    @FXML
    private Button toBackButton;
    @FXML
    private Pane drawingPane;
    @FXML
    private GridPane gridPane;
    @FXML
    private ToggleButton gridButton;
    @FXML
    private Button plusGrid;
    @FXML
    private Button lessGrid;
    @FXML
    private Button zoomPlus;
    @FXML
    private Button zoomMinus;
    @FXML
    private ScrollPane scrollPane;
    private Zoom zoomHandler;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toolManager = new Tools();
        fileManager = new FileManager(drawingPane);
        fileChooser = new FileChooser();
        shapeEditor = new Editor();
        clipboard = new CustomClipboard();
        gridHandler = new GridHandler(gridPane, gridButton);
        zoomHandler = new Zoom(drawingPane);

        toolManager.setShapeLineColor(Color.BLACK);
        toolManager.setShapeFillColor(Color.TRANSPARENT);

        lineButton.disableProperty().bind(moveToggle.selectedProperty());
        rectangleButton.disableProperty().bind(moveToggle.selectedProperty());
        ellipseButton.disableProperty().bind(moveToggle.selectedProperty());
        toFrontButton.disableProperty().bind(moveToggle.selectedProperty());
        toBackButton.disableProperty().bind(moveToggle.selectedProperty());
        plusGrid.disableProperty().bind(moveToggle.selectedProperty());
        lessGrid.disableProperty().bind(moveToggle.selectedProperty());
        gridButton.disableProperty().bind(moveToggle.selectedProperty());

        //add binding between gridButton and + and - buttons
        BooleanProperty gridButtonSelected = new SimpleBooleanProperty();
        gridButtonSelected.bind(gridButton.selectedProperty());
        plusGrid.disableProperty().bind(gridButtonSelected.not());
        lessGrid.disableProperty().bind(gridButtonSelected.not());

        // add a border to the pane di colore chiaro per evidenziare il bordo
        //scrollPane.setStyle("-fx-border-color: lightgray;");
        drawingPane.setStyle("-fx-border-color: lightgray;");
        //gridPane.setStyle("-fx-border-color: lightgray;");

        //imposta la stessa dimensione per il gridPane, il drawingPane e il scrollPane
        //gridPane.prefWidthProperty().bind(scrollPane.widthProperty());
        //gridPane.prefHeightProperty().bind(scrollPane.heightProperty());
        //drawingPane.prefWidthProperty().bind(gridPane.widthProperty());
        //drawingPane.prefHeightProperty().bind(gridPane.heightProperty());

        //adatta la dimensione del gridPane al pane
        //gridPane.prefWidthProperty().bind(drawingPane.widthProperty());
        //gridPane.prefHeightProperty().bind(drawingPane.heightProperty());

        gridPane.setMouseTransparent(true);
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
                    clipboard.copy(target);
                });

                paste.setOnAction((ActionEvent event) -> {
                    clipboard.paste(drawingPane, selectionPointX, selectionPointY);
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
        Color colorInit = toolManager.getShapeLineColor();
        toolManager.setShapeLineColor(lineColorPicker.getValue());
        Command cmd = new ChangeLineColorCommand( shapeEditor.getSelectedNode(), drawingPane, lineColorPicker, colorInit);
        shapeEditor.executeCommand(cmd);

    }

    @FXML
    public void setFillColor(ActionEvent actionEvent) {
        Color colorInit = toolManager.getShapeFillColor();
        toolManager.setShapeFillColor(fillColorPicker.getValue());
        Command cmd = new ChangeFillColorCommand( shapeEditor.getSelectedNode(), drawingPane, fillColorPicker, colorInit );
        shapeEditor.executeCommand(cmd);
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
    @Deprecated
    public void setPlusSize(ActionEvent actionEvent) {
        Command cmd = new PlusSizeCommand(shapeEditor.getSelectedNode());
        shapeEditor.executeCommand(cmd);
    }

    @Deprecated
    public void setMinusSize(ActionEvent actionEvent) {
        Command cmd = new MinusSizeCommand(shapeEditor.getSelectedNode());
        shapeEditor.executeCommand(cmd);
    }

    @FXML
    public void setToBack(ActionEvent actionEvent) {
        Command cmd = new ToBackCommand(shapeEditor.getSelectedNode());
        shapeEditor.executeCommand(cmd);
    }

    @FXML
    public void putToFront(ActionEvent actionEvent) {
        Command cmd = new ToFrontCommand(shapeEditor.getSelectedNode());
        shapeEditor.executeCommand(cmd);
    }

    @FXML
    public void toggleGrid(ActionEvent actionEvent) {
        gridHandler.toggleGrid();
    }

    @FXML
    public void makeGridBigger(ActionEvent actionEvent) {
        gridHandler.plusGrid();
    }

    @FXML
    public void makeGridSmaller(ActionEvent actionEvent) {
        gridHandler.minusGrid();
    }

    @FXML
    public void zoomPlusAction(ActionEvent actionEvent) {
        //zoomHandler.zoomPlus();
        Scale scale = new Scale();
        scale.setX(drawingPane.getScaleX() + 0.1);
        scale.setY(drawingPane.getScaleY() + 0.1);
        scale.setPivotX(0);
        scale.setPivotY(0);

        //add the scale transformation to all the shapes
        /*for (Node node : drawingPane.getChildren()) {
            node.getTransforms().add(scale);
        }*/
        drawingPane.getTransforms().add(scale);
        scale.setX(gridPane.getScaleX() + 0.1);
        scale.setY(gridPane.getScaleY() + 0.1);
        scale.setPivotX(0);
        scale.setPivotY(0);
        gridPane.getTransforms().add(scale);

        drawingPane.setPrefWidth(drawingPane.getPrefWidth() + 100);
        drawingPane.setPrefHeight(drawingPane.getPrefHeight() + 100);

        //gridPane.setPrefWidth(gridPane.getPrefWidth() + 100);
        //gridPane.setPrefHeight(gridPane.getPrefHeight() + 100);

        //gridPane.setPrefWidth(drawingPane.getPrefWidth());
        //gridPane.setPrefHeight(drawingPane.getPrefHeight());
    }
    @FXML
    public void zoomMinusAction(ActionEvent actionEvent) {
        Scale scale = new Scale();
        scale.setX(drawingPane.getScaleX() - 0.1);
        scale.setY(drawingPane.getScaleY() - 0.1);
        scale.setPivotX(0);
        scale.setPivotY(0);
        drawingPane.getTransforms().add(scale);

        /*for (Node node : drawingPane.getChildren()) {
            node.getTransforms().add(scale);
        }*/

        scale.setX(gridPane.getScaleX() - 0.1);
        scale.setY(gridPane.getScaleY() - 0.1);
        scale.setPivotX(0);
        scale.setPivotY(0);
        gridPane.getTransforms().add(scale);

        /*Transform test = drawingPane.getTransforms().get(0);
        if (test.getMxx() > 1) {
            drawingPane.setPrefWidth(drawingPane.getPrefWidth() - 100);
            drawingPane.setPrefHeight(drawingPane.getPrefHeight() - 100);
        }*/

        /*Transform test2 = gridPane.getTransforms().get(0);
        if (test2.getMxx() > 1) {
            gridPane.setPrefWidth(gridPane.getPrefWidth() - 100);
            gridPane.setPrefHeight(gridPane.getPrefHeight() - 100);
        }*/

        //imposta la dimensione del pane uguale a quello della griglia
        //gridPane.setPrefWidth(drawingPane.getPrefWidth());
        //gridPane.setPrefHeight(drawingPane.getPrefHeight());

    }

}

