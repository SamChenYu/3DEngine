package render;

import java.awt.*;
public class Square {
    public Vertex v1;
    public Vertex v2;
    public Vertex v3;
    public Vertex v4;
    public Color color;
    public Square(Vertex v1, Vertex v2, Vertex v3, Vertex v4, Color color) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
        this.color = color;
    }
}