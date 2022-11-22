package diem.unisa.softwareengineering.tools;

import javafx.scene.shape.Shape;

public class Context {
    //add an instance of the Shape class
    private Shape shape;

    //add an initializer for the Context class
    public Context() {
        //shape = new DrawableLine(); //default shape is our line class

    }

    //add a method changeState that instantiates the shape as for the passed parameter
    public void changeState(Shape state){
       shape = state; //this will be line, circle, rectangle, etc.

    }


}
