package gui;

import render.*;

import javax.swing.*;

import java.awt.*;

import java.awt.geom.Path2D;

import java.util.List;
import java.util.ArrayList;
public class Panel extends JPanel {

    List<Triangle> tris;
    MouseHandler mouseH;
    KeyHandler keyH;

    public boolean mouseInput = true;

    public Panel() {
        setBackground(Color.BLACK);
        mouseH = new MouseHandler(this);
        addMouseMotionListener(mouseH);
        keyH = new KeyHandler(this);
        addKeyListener(keyH);
        setFocusable(true);

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

        double heading, pitch;

        if(mouseInput) {
            heading = mouseH.getAngleX();
            pitch = mouseH.getAngleY();
            System.out.println( heading + " " + pitch);
        } else {
            heading = keyH.getAngleX();
            pitch = keyH.getAngleY();
        }

        Matrix3 headingTransform = new Matrix3(new double[] {
                Math.cos(heading), 0, Math.sin(heading),
                0, 1, 0,
                -Math.sin(heading), 0, Math.cos(heading)
        });

        Matrix3 pitchTransform = new Matrix3(new double[] {
                1, 0, 0,
                0, Math.cos(pitch), Math.sin(pitch),
                0, -Math.sin(pitch), Math.cos(pitch)
        });
        Matrix3 transform = headingTransform.multiply(pitchTransform);


        g2.translate(getWidth() / 2, getHeight() / 2);
        g2.setColor(Color.WHITE);
        for (Triangle t : tris) {
            Vertex v1 = transform.transform(t.v1);
            Vertex v2 = transform.transform(t.v2);
            Vertex v3 = transform.transform(t.v3);
            Path2D path = new Path2D.Double();
            path.moveTo(v1.x, v1.y);
            path.lineTo(v2.x, v2.y);
            path.lineTo(v3.x, v3.y);
            path.closePath();
            g2.draw(path);


        }
    }
}
