package diem.unisa.softwareengineering.tools;

import javafx.scene.layout.Pane;



/**
 * A class used to apply the Command pattern that contains the abstract methods execute and undo
 */
public abstract class Command {

    public abstract void execute();

    public abstract void undo();


}
