package gui;

import render.Triangle;
import render.Vertex;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.List;
import java.util.ArrayList;
public class Panel extends JPanel {

    List<Triangle> tris;
    public Panel() {
        setBackground(Color.BLACK);

        tris = new ArrayList<>();
        tris.add(new Triangle(  new Vertex(100, 100, 100),
                                new Vertex(-100, -100, 100),
                                new Vertex(-100, 100, -100),
                                Color.WHITE));
        tris.add(new Triangle(  new Vertex(100, 100, 100),
                                new Vertex(-100, -100, 100),
                                new Vertex(100, -100, -100),
                                Color.RED));
        tris.add(new Triangle(  new Vertex(-100, 100, -100),
                                new Vertex(100, -100, -100),
                                new Vertex(100, 100, 100),
                                Color.GREEN));
        tris.add(new Triangle(  new Vertex(-100, 100, -100),
                                new Vertex(100, -100, -100),
                                new Vertex(-100, -100, 100),
                                Color.BLUE));

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.translate(getWidth() / 2, getHeight() / 2);
        g2.setColor(Color.WHITE);
        for (Triangle t : tris) {
            Path2D path = new Path2D.Double();
            path.moveTo(t.v1.x, t.v1.y);
            path.lineTo(t.v2.x, t.v2.y);
            path.lineTo(t.v3.x, t.v3.y);
            path.closePath();
            g2.draw(path);
        }
    }
}
