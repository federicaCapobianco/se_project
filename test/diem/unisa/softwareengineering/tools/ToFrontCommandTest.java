package diem.unisa.softwareengineering.tools;

import diem.unisa.softwareengineering.commands.ToFrontCommand;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToFrontCommandTest {
    @Test
    void testExecute() {
        Pane pane = new Pane();
        Line line = new Line(1, 2, 3, 4);
        Line line2 = new Line(1, 2, 3, 4);
        pane.getChildren().add(line);
        pane.getChildren().add(line2);

        final ToFrontCommand toFrontCommand = new ToFrontCommand(line);
        toFrontCommand.execute();
        assertEquals(1, pane.getChildren().indexOf(line));
        assertEquals(0, pane.getChildren().indexOf(line2));

        line2.toFront();

        assertEquals(0, pane.getChildren().indexOf(line));
        assertEquals(1, pane.getChildren().indexOf(line2));
    }

    @Test
    void testUndo() {
        Pane pane = new Pane();
        Line line = new Line(1, 2, 3, 4);
        Line line2 = new Line(1, 2, 3, 4);
        pane.getChildren().add(line);
        pane.getChildren().add(line2);

        final ToFrontCommand toFrontCommand = new ToFrontCommand(line);
        toFrontCommand.execute();
        assertEquals(1, pane.getChildren().indexOf(line));
        assertEquals(0, pane.getChildren().indexOf(line2));

        toFrontCommand.undo();

        assertEquals(0, pane.getChildren().indexOf(line));
        assertEquals(1, pane.getChildren().indexOf(line2));
    }
}