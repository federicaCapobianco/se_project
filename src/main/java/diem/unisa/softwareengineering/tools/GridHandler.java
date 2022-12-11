package diem.unisa.softwareengineering.tools;

import javafx.scene.control.ToggleButton;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 * The GridHandler class is used to create a grid on the canvas and resize it.
 */
public class GridHandler {
    private GridPane gridPane;
    private ToggleButton gridButton;

    public GridHandler(GridPane gridPane, ToggleButton gridButton){
        this.gridPane = gridPane;
        this.gridButton = gridButton;
    }

    public void toggleGrid(){
        if(gridButton.isSelected()){
            gridPane.setStyle("" +"-fx-grid-lines-visible: true;");
        }
        else{
            gridPane.setStyle("" +"-fx-grid-lines-visible: false;");
        }
    }

    public void plusGrid(){
        double width = gridPane.getWidth();
        double height = gridPane.getHeight();
        int columns = gridPane.getColumnCount()-1;
        int rows = gridPane.getRowCount()-1;
        double newWidth = width / columns;
        double newHeight = height / rows;
        gridPane.getColumnConstraints().clear();
        gridPane.getRowConstraints().clear();

        for (int i = 0; i < columns; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPrefWidth(newWidth);
            gridPane.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < rows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPrefHeight(newHeight);
            gridPane.getRowConstraints().add(rowConst);
        }
    }

    public void minusGrid(){
        double width = gridPane.getWidth();
        double height = gridPane.getHeight();

        int columns = gridPane.getColumnCount()+1;
        int rows = gridPane.getRowCount()+1;
        double newWidth = width / columns;
        double newHeight = height / rows;
        gridPane.getColumnConstraints().clear();
        gridPane.getRowConstraints().clear();

        for (int i = 0; i < columns; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPrefWidth(newWidth);
            gridPane.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < rows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPrefHeight(newHeight);
            gridPane.getRowConstraints().add(rowConst);
        }
    }
}
