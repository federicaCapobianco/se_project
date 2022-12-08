package diem.unisa.softwareengineering.tools;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class DrawableText extends DrawableShape{

    private Text textShape;
    @Override
    public Shape draw(double xS, double yS, double xE, double yE, Color lineColor, Color fillColor, String text) {
        this.textShape = new Text();
        textShape.setText(text);
        textShape.setX(xS);
        textShape.setY(yS);
        textShape.setStroke(lineColor);
        textShape.setFill(fillColor);
        return textShape;
    }
}
