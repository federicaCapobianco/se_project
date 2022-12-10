package diem.unisa.softwareengineering.tools;

import javafx.application.Platform;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridHandlerTest {
    @BeforeAll
    static void initJfxRuntime() {
        Platform.startup(() -> {});
    }

    @Test
    void testToggleGrid() {
        GridPane gridPane = new GridPane();
        ToggleButton gridButton = new ToggleButton();
        GridHandler gridHandler = new GridHandler(gridPane, gridButton);
        gridButton.setSelected(true);
        gridHandler.toggleGrid();
        assertTrue(gridPane.getStyle().contains("-fx-grid-lines-visible: true;"));

    }
    @Test
    void testPlusGrid() {
        GridPane gridPane = new GridPane();
        ToggleButton gridButton = new ToggleButton();
        GridHandler gridHandler = new GridHandler(gridPane, gridButton);
        gridPane.setPrefSize(100,100);
        gridPane.setGridLinesVisible(true);
        gridPane.getColumnConstraints().clear();
        gridPane.getRowConstraints().clear();
        gridPane.getColumnConstraints().add(new ColumnConstraints());
        gridPane.getColumnConstraints().add(new ColumnConstraints());
        gridPane.getRowConstraints().add(new RowConstraints());
        gridPane.getRowConstraints().add(new RowConstraints());
        gridHandler.plusGrid();
        assertEquals(1, gridPane.getColumnCount());
        assertEquals(1, gridPane.getRowCount());
    }
    @Test
    void testMinusGrid() {
        GridPane gridPane = new GridPane();
        ToggleButton gridButton = new ToggleButton();
        GridHandler gridHandler = new GridHandler(gridPane, gridButton);
        gridPane.setPrefSize(100,100);
        gridPane.setGridLinesVisible(true);
        gridPane.getColumnConstraints().clear();
        gridPane.getRowConstraints().clear();
        gridPane.getColumnConstraints().add(new ColumnConstraints());
        gridPane.getColumnConstraints().add(new ColumnConstraints());
        gridPane.getRowConstraints().add(new RowConstraints());
        gridPane.getRowConstraints().add(new RowConstraints());
        gridHandler.minusGrid();
        assertEquals(3, gridPane.getColumnCount());
        assertEquals(3, gridPane.getRowCount());
    }
}