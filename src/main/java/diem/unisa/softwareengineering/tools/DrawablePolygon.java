package diem.unisa.softwareengineering.tools;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DrawablePolygon extends DrawableShape{
    private Polygon polygon;
    private List totalPoints;
    private Queue currentPoints;
    private List polygonLine;

    public DrawablePolygon(){
        totalPoints = new ArrayList();
        currentPoints = new ArrayDeque();
        polygonLine = new ArrayList();
    }
    public Shape closureDraw(Color lineColor, Color fillColor){
        Polygon removed;

        for(int i=0; i<polygonLine.size(); i++){
            removed = (Polygon) polygonLine.get(i);
            removed.setOpacity(0);
        }
        this.polygon.getPoints().addAll(totalPoints);
        this.polygon.setOpacity(1);
        this.polygon.setStroke(lineColor);
        this.polygon.setFill(fillColor);

        currentPoints.clear();
        totalPoints.clear();
        polygonLine.clear();

        return polygon;
    }

    @Override
    public Shape draw(double xS, double yS, double xE, double yE, Color lineColor, Color fillColor, String text) {
        this.polygon = new Polygon();

        this.currentPoints.add(xS);
        this.currentPoints.add(yS);
        this.totalPoints.add(xS);
        this.totalPoints.add(yS);

        this.polygon.getPoints().addAll(currentPoints);
        this.polygon.setStroke(lineColor);
        this.polygonLine.add(this.polygon);

        if(currentPoints.size() == 4) {
            currentPoints.remove();
            currentPoints.remove();
        }

        return polygon;
    }


}
