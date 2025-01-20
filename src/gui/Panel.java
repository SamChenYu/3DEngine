package gui;

import math.*;
import geometry.*;
import math.Color;

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


    public Panel(int width, int height) {
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
        Random random = new Random();
        // Todo: Remove this into scene class
        Sphere sphere = new Sphere(
                new Point3D(0.0, 0.0, 0.0),
                60.0,
                new Color(1.0F, 0.0F, 0.0F)
        );


        long renderStart = System.currentTimeMillis();
        for(int x=0; x<WIDTH; x++) {
            for(int y=0; y<HEIGHT; y++) {

                final int renderX = (int) (0.4*(x-WIDTH/2+.5));
                final int renderY = (int) (0.4*(y-HEIGHT/2+.5));
                final int renderZ = 100;

                // ANTI-ALIASING
                final int samples = 8;
                math.Color color = new math.Color(0.0F, 0.0F, 0.0F); // initially black
                for(int row = 0; row < samples; row++) {
                    for(int col = 0; col < samples; col++) {
                        Ray ray = new Ray(
                                // Regular sampling
                                new Point3D(renderX/2+(col+random.nextFloat())/samples, renderY/2+(row+random.nextFloat())/samples, renderZ),
                                new Vector3D(0.0, 0.0, -1.0)
                        );
                        if(sphere.hit(ray) != 0.0) {
                            color.add(sphere.color);
                        } else {
                            color.add(new math.Color(0.0F, 0.0F, 0.0F)); // adding background
                        }

                    } // For COL
                } // FOR Row
                color.divide(samples*samples); // 8x8 = 64
                img.setRGB(x,y, color.toInteger());
                /*
                Ray ray = new Ray(
                        new Point3D(renderX, renderY, renderZ),
                        new Vector3D(0.0, 0.0, -1.0)
                );

                    //Orthographic Projection:
                    //Parallel lines do not converge
                    //Objects are the same size regardless of distance
                    //Point3D:
                    //X = x-WIDTH/2+.5 to center the image on the view plane
                    //Y = y-HEIGHT/2+.5 to center the image on the view plane
                    //Z = 1000 to move the view plane 1000 units away from the camera - any arbitrary value

                    //The size of objects is dependent on the size of the view plane

                if(sphere.hit(ray) != 0.0) {
                    img.setRGB(x, y, sphere.color.toInteger());
                } else {
                    img.setRGB(x, y, java.awt.Color.BLACK.getRGB());
                }
                */
            }
        }
        long renderEnd = System.currentTimeMillis();
        System.out.println("Time taken: " + (renderEnd - renderStart) / 1000.0 + " seconds");



        g2.drawImage(img, 0, 0, null);


    }


}
