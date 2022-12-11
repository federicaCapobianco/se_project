package diem.unisa.softwareengineering.tools;

import diem.unisa.softwareengineering.commands.CutCommand;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CutCommandTest {
    @Test
    void testExecute() {
        Pane canva = new Pane();
        CustomClipboard clipboard = new CustomClipboard();
        Line line = new Line(0, 0, 10, 10);
        canva.getChildren().add(line);
        CutCommand cutCommand = new CutCommand(line, canva, clipboard);
        cutCommand.execute();
        assertEquals(0, canva.getChildren().size());
        clipboard.paste(canva, 0, 0);
        assertEquals(1, canva.getChildren().size());
    }

    @Test
    void testUndo() {
        Pane canva = new Pane();
        CustomClipboard clipboard = new CustomClipboard();
        Line line = new Line(0, 0, 10, 10);
        canva.getChildren().add(line);
        CutCommand cutCommand = new CutCommand(line, canva, clipboard);
        cutCommand.execute();
        cutCommand.undo();
        assertEquals(1, canva.getChildren().size());
    }

}