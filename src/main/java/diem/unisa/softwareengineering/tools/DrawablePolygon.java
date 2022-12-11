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
    private List totalPoints; //lista con tutti i punti, tramite cui si crea la vera e propria polygon shape
    private Queue currentPoints; //lista di appoggio per permettere la visualizzazione del disegno del poligono
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

        this.polygon.getPoints().addAll(currentPoints); //totalPoints instead of currentPoints: si avrebbe poligono come somma di triangoli
        this.polygon.setStroke(lineColor);
        this.polygonLine.add(this.polygon);

        if(currentPoints.size() == 4) { //per permettere il disegno del poligono lato per lato (eccetto l'ultimo) e non come somma di triangoli
            currentPoints.remove();
            currentPoints.remove();
        }

        return polygon;
    }


}
