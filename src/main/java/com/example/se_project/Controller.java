package com.example.se_project;

import diem.unisa.softwareengineering.tools.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.beans.DefaultPersistenceDelegate;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
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

    ContextMenu contextMenu = new ContextMenu();
    MenuItem deselect = new MenuItem("Deselect");
    MenuItem delete = new MenuItem("Delete");
    MenuItem move = new MenuItem("Move");
    MenuItem lineColor = new MenuItem("Line color");
    MenuItem fillColor = new MenuItem("Fill color");
    MenuItem size = new MenuItem("Size");
    MenuItem copy = new MenuItem("Copy");
    MenuItem paste = new MenuItem("Paste");
    DropShadow dropShadow = new DropShadow();

    private Tools toolManager;
    private FileManager fileManager;
    private FileChooser fileChooser;
    private Editor shapeEditor;
    private final Clipboard clipboard = Clipboard.getSystemClipboard();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toolManager = new Tools();
        fileManager = new FileManager(drawingPane);
        fileChooser = new FileChooser();
        shapeEditor = new Editor();

        toolManager.setShapeLineColor(Color.BLACK);
        toolManager.setShapeFillColor(Color.TRANSPARENT);
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
    public void mouseDown(MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseButton.SECONDARY) {
            Node target = (Node) mouseEvent.getTarget();

            if(target instanceof Shape) {
                target.setEffect(null);
                shapeEditor.addSelectedNode((Shape)target);
            }

            contextMenu.getItems().addAll(deselect, delete, move, lineColor, fillColor, size, copy, paste);
            contextMenu.show(drawingPane, mouseEvent.getScreenX(), mouseEvent.getScreenY());

            dropShadow.setRadius(5.0);
            dropShadow.setOffsetX(3.0);
            dropShadow.setOffsetY(3.0);
            dropShadow.setColor(Color.color(0.4, 0.5, 0.5));

            target.setEffect(dropShadow);

            deselect.setOnAction((ActionEvent event) -> {
                shapeEditor.removeSelectedNode((Shape)target);
                target.setEffect(null);
            });

            copy.setOnAction((ActionEvent event) -> {
                System.out.println("copy");
                //get the file named copy.xml
                File file = new File("copy.xml");
                try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(Files.newOutputStream(file.toPath())))) {
                    encoder.setPersistenceDelegate(Color.class, new DefaultPersistenceDelegate(new String[]{"red", "green", "blue", "opacity"}));
                    encoder.writeObject(target);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ClipboardContent content = new ClipboardContent();
                List<File> files = List.of(file);
                content.putFiles(files);

                System.out.println("done copy");
            });

            paste.setOnAction((ActionEvent event) -> {
                System.out.println("paste");
                List<File> files = clipboard.getFiles();
                try (XMLDecoder decoder = new XMLDecoder(
                        new BufferedInputStream(
                                Files.newInputStream(new File("copy.xml").toPath())))) {

                    decoder.setExceptionListener(e -> {
                        throw new RuntimeException(e);
                    });

                    Shape nodeToAdd = (Shape) decoder.readObject();

                    //move the node to the mouse position
                    nodeToAdd.setTranslateX(nodeToAdd.getTranslateX()+mouseEvent.getX());
                    nodeToAdd.setTranslateY(nodeToAdd.getTranslateY()+mouseEvent.getY());
                    System.out.println("node: "+nodeToAdd+"x: "+nodeToAdd.getTranslateX()+" y: "+nodeToAdd.getTranslateY());
                    drawingPane.getChildren().add(nodeToAdd);
                    drawingPane.getChildren().add(new Rectangle(100,100,Color.RED));
                }
                catch (Exception e) {
                    e.printStackTrace();
                }


                System.out.println("done paste");
            });
        }
        else if(mouseEvent.getButton() == MouseButton.PRIMARY) {
            for(Shape shape : shapeEditor.getSelectedNodes()) {
                shape.setEffect(null);
            }
            shapeEditor.clearSelectedNodes();
            //iterate over selectedNodes
            toolManager.setxS(mouseEvent.getX());
            toolManager.setyS(mouseEvent.getY());
        }
        //could draw a temporary shape here
    }

    @FXML
    public void mouseUp(MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseButton.SECONDARY) {
        }
        else if(mouseEvent.getButton() == MouseButton.PRIMARY) {
            toolManager.setxE(mouseEvent.getX());
            toolManager.setyE(mouseEvent.getY());

            Shape shape = toolManager.draw();
            drawingPane.getChildren().add(shape);
        }
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
    public void setLineColor(ActionEvent actionEvent) {
        toolManager.setShapeLineColor(lineColorPicker.getValue());
    }

    @FXML
    public void setFillColor(ActionEvent actionEvent) {
        toolManager.setShapeFillColor(fillColorPicker.getValue());
    }

}