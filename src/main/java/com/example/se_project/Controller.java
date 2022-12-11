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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    private ContextMenu contextMenu;
    private MenuItem deselect;
    private MenuItem delete;
    private MenuItem copy;
    private MenuItem paste;
    private MenuItem cut;
    private DropShadow dropShadow;
    private Tools toolManager;
    private FileManager fileManager;
    private FileChooser fileChooser;
    private Editor shapeEditor;
    private CustomClipboard clipboard;
    private GridHandler gridHandler;
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
    private ToggleButton moveToggle;
    @FXML
    private Button toFrontButton;
    @FXML
    private Button toBackButton;
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
    @FXML
    private Zoom windowZoomHandler;
    @FXML
    private TextField stretchX;
    @FXML
    private TextField stretchY;
    @FXML
    private Button textButton;
    @FXML
    private TextField textTextField;
    @FXML
    private ToggleButton polygonButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        contextMenu = new ContextMenu();
        deselect = new MenuItem("Deselect");
        delete = new MenuItem("Delete");
        copy = new MenuItem("Copy");
        paste = new MenuItem("Paste");
        cut = new MenuItem("Cut");

        dropShadow = new DropShadow();

        contextMenu.getItems().addAll(deselect, delete, copy, paste, cut);

        toolManager = new Tools();
        fileManager = new FileManager(drawingPane);
        fileChooser = new FileChooser();
        shapeEditor = new Editor();
        clipboard = new CustomClipboard();
        gridHandler = new GridHandler(gridPane, gridButton);
        windowZoomHandler = new Zoom(drawingPane, gridPane);

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

        gridPane.setMouseTransparent(true);

        textTextField.disableProperty().setValue(true);
        textTextField.setText("Add here your text");

        lineButton.disableProperty().bind(polygonButton.selectedProperty());
        rectangleButton.disableProperty().bind(polygonButton.selectedProperty());
        ellipseButton.disableProperty().bind(polygonButton.selectedProperty());

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
    @FXML
    public void setPolygon(ActionEvent actionEvent) {
        if(polygonButton.selectedProperty().getValue()==false){
            toolManager.closureDraw();
            polygonButton.selectedProperty().setValue(true);
            toolManager.changeState(new DrawablePolygon());
        }
        toolManager.changeState(new DrawablePolygon());
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


                contextMenu.show(drawingPane, mouseEvent.getScreenX(), mouseEvent.getScreenY());

                dropShadow.setRadius(5.0);
                dropShadow.setOffsetX(3.0);
                dropShadow.setOffsetY(3.0);
                dropShadow.setColor(Color.color(0.4, 0.5, 0.5));

                deselect.setOnAction((ActionEvent event) -> {
                    shapeEditor.deselectShape(target);
                });

                copy.setOnAction((ActionEvent event) -> {
                    Command cmd = new CopyCommand(target, clipboard);
                    shapeEditor.executeCommand(cmd);
                });

                paste.setOnAction((ActionEvent event) -> {
                    Command cmd = new PasteCommand(drawingPane,selectionPointX,selectionPointY,clipboard);
                    shapeEditor.executeCommand(cmd);
                });

                delete.setOnAction((ActionEvent event) -> {
                    Command cmd = new DeleteCommand(shapeEditor.getSelectedNode(), drawingPane);
                    shapeEditor.executeCommand(cmd);
                });

                cut.setOnAction((ActionEvent event) -> {
                    Command cmd = new CutCommand(shapeEditor.getSelectedNode(), drawingPane, clipboard);
                    shapeEditor.executeCommand(cmd);
                });

            } else if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                contextMenu.hide();
                if(moveToggle.isSelected()){
                    Command cmd = new MoveCommand(shapeEditor.getSelectedNode(), drawingPane, mouseEvent.getX(), mouseEvent.getY());
                    shapeEditor.executeCommand(cmd);
                } else {
                        toolManager.setxS(mouseEvent.getX());
                        toolManager.setyS(mouseEvent.getY());
                        Node selectedNode = shapeEditor.getSelectedNode();
                        if (selectedNode != null) {
                            selectedNode.setEffect(null);
                        }
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

    @FXML
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
        windowZoomHandler.zoomPlus();
    }
    @FXML
    public void zoomMinusAction(ActionEvent actionEvent) {
        windowZoomHandler.zoomMinus();
    }


    public void mirrorHorizontal(ActionEvent actionEvent) {
        Command cmd = new MirrorHorizontalCommand(shapeEditor.getSelectedNode());
        shapeEditor.executeCommand(cmd);
    }

    @FXML
    public void mirrorVertical(ActionEvent actionEvent) {
        Command cmd = new MirrorVerticalCommand(shapeEditor.getSelectedNode());
        shapeEditor.executeCommand(cmd);
    }

    @FXML
    public void stretchHorizontal(ActionEvent actionEvent) {
        Double n = Double.parseDouble(this.stretchX.getText());
        Command cmd = new StretchHorizontalCommand(shapeEditor.getSelectedNode(),n);
        shapeEditor.executeCommand(cmd);
        this.stretchX.clear();
    }

    @FXML
    public void stretchVertical(ActionEvent actionEvent) {
        Double n = Double.parseDouble(this.stretchY.getText());
        Command cmd = new StretchVerticalCommand(shapeEditor.getSelectedNode(), n);
        shapeEditor.executeCommand(cmd);
        this.stretchY.clear();
    }

    @FXML
    public void rotateLeft(ActionEvent actionEvent) {
        Command cmd = new RotateCommandLeft(shapeEditor.getSelectedNode());
        shapeEditor.executeCommand(cmd);
    }

    @FXML
    public void rotateRight(ActionEvent actionEvent) {
        Command cmd = new RotateCommandRight(shapeEditor.getSelectedNode());
        shapeEditor.executeCommand(cmd);
    }
    
    @FXML
    public void setTextShape(ActionEvent actionEvent) {
        toolManager.changeState(new DrawableText());
        textTextField.disableProperty().setValue(false);
        textTextField.setText("");
    }

    @FXML
    public void setTextString(ActionEvent actionEvent) {
        toolManager.setTextString(textTextField.getText());
    }

}

