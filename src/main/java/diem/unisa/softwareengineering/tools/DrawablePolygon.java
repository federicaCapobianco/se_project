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

    private List totalPoints = new ArrayList(); //lista con tutti i punti, tramite cui si crea la vera e propria polygon shape

    private Queue currentPoints = new ArrayDeque(); //lista di appoggio per permettere la visualizzazione del disegno del poligono

    public Shape closureDraw(Color lineColor, Color fillColor){

        this.polygon.getPoints().addAll(totalPoints);
        this.polygon.setStroke(lineColor);
        this.polygon.setFill(fillColor);

        currentPoints.clear();
        totalPoints.clear();

        return polygon;
    }

    @Override
    public Shape draw(double xS, double yS, double xE, double yE, Color lineColor, Color fillColor) {
        this.polygon = new Polygon();

        this.currentPoints.add(xS);
        this.currentPoints.add(yS);
        this.totalPoints.add(xS);
        this.totalPoints.add(yS);

        this.polygon.getPoints().addAll(currentPoints); //totalPoints instead of currentPoints: si avrebbe poligono come somma di triangoli
        this.polygon.setStroke(lineColor);

        if(currentPoints.size() == 4) { //per permettere il disegno del poligono lato per lato (eccetto l'ultimo) e non come somma di triangoli
            currentPoints.remove();
            currentPoints.remove();
        }

        return polygon;
    }


}
