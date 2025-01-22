package gui;

import math.*;
import geometry.*;
import math.Color;
import scene.Tracer;
import scene.World;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Panel extends JPanel {

    // Constants
    private final int WIDTH;
    private final int HEIGHT;

    // DI objects
    MouseHandler mouseH;
    KeyHandler keyH;
    public boolean mouseInput = true;

    public Tracer tracer;

    public final World world;


    public Panel(int width, int height, World world) {
        tracer = new Tracer(width, height, world);
        this.world = world;
        WIDTH = width;
        HEIGHT = height;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(java.awt.Color.BLACK);
        mouseH = new MouseHandler(this);
        addMouseMotionListener(mouseH);
        addMouseWheelListener(mouseH);
        keyH = new KeyHandler(this);
        addKeyListener(keyH);
        setFocusable(true);
    }




    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;


        BufferedImage img =
                new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        long renderStart = System.currentTimeMillis();
        for(int x=0; x<WIDTH; x++) {
            for(int y=0; y<HEIGHT; y++) {
                img.setRGB(x,y, tracer.trace(x, y));
            }
        }
        long renderEnd = System.currentTimeMillis();
        System.out.println("Time taken: " + (renderEnd - renderStart) / 1000.0 + " seconds");



        g2.drawImage(img, 0, 0, null);


    }


}
