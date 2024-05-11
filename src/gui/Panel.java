package gui;

import render.*;

import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.geom.Path2D;

import java.util.List;
import java.util.ArrayList;
public class Panel extends JPanel {

    List<Triangle> shape;
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

        shape = new ArrayList<>();
        shape.add(new Triangle(  new Vertex(200, 200, 200),
                                new Vertex(-200, -200, 200),
                                new Vertex(-200, 200, -200),
                                Color.YELLOW));
        shape.add(new Triangle(  new Vertex(200, 200, 200),
                                new Vertex(-200, -200, 200),
                                new Vertex(200, -200, -200),
                                Color.RED));
        shape.add(new Triangle(  new Vertex(-200, 200, -200),
                                new Vertex(200, -200, -200),
                                new Vertex(200, 200, 200),
                                Color.GREEN));
        shape.add(new Triangle(  new Vertex(-200, 200, -200),
                                new Vertex(200, -200, -200),
                                new Vertex(-200, -200, 200),
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

            keyH.setAngleX(heading);
            keyH.setAngleY(pitch);
        } else {
            heading = keyH.getAngleX();
            pitch = keyH.getAngleY();
            mouseH.setAngleX(heading);
            mouseH.setAngleY(pitch);
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

        BufferedImage img =
                new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);


        // Z - buffering
        double[] zBuffer = new double[img.getWidth() * img.getHeight()];
        // initialize array with extremely far away depths
        for (int q = 0; q < zBuffer.length; q++) {
            zBuffer[q] = Double.NEGATIVE_INFINITY;
        }

        for (Triangle t : shape) {
            // rasterize triangle
            Vertex v1 = transform.transform(t.v1);
            Vertex v2 = transform.transform(t.v2);
            Vertex v3 = transform.transform(t.v3);

            // since we are not using Graphics2D anymore   ,
            // we have to do translation manually
            v1.x += getWidth() / 2;
            v1.y += getHeight() / 2;
            v2.x += getWidth() / 2;
            v2.y += getHeight() / 2;
            v3.x += getWidth() / 2;
            v3.y += getHeight() / 2;

            // compute normal vector for shading
            Vertex ab = new Vertex(v2.x - v1.x, v2.y - v1.y, v2.z - v1.z);
            Vertex ac = new Vertex(v3.x - v1.x, v3.y - v1.y, v3.z - v1.z);
            Vertex norm = new Vertex(
                    ab.y * ac.z - ab.z * ac.y,
                    ab.z * ac.x - ab.x * ac.z,
                    ab.x * ac.y - ab.y * ac.x
            );
            double normalLength =
                    Math.sqrt(norm.x * norm.x + norm.y * norm.y + norm.z * norm.z);
            norm.x /= normalLength;
            norm.y /= normalLength;
            norm.z /= normalLength;

            double angleCos = Math.abs(norm.z);



            // compute rectangular bounds for triangle
            int minX = (int) Math.max(0, Math.ceil(Math.min(v1.x, Math.min(v2.x, v3.x))));
            int maxX = (int) Math.min(img.getWidth() - 1,
                    Math.floor(Math.max(v1.x, Math.max(v2.x, v3.x))));
            int minY = (int) Math.max(0, Math.ceil(Math.min(v1.y, Math.min(v2.y, v3.y))));
            int maxY = (int) Math.min(img.getHeight() - 1,
                    Math.floor(Math.max(v1.y, Math.max(v2.y, v3.y))));

            double triangleArea =
                    (v1.y - v3.y) * (v2.x - v3.x) + (v2.y - v3.y) * (v3.x - v1.x);

            for (int y = minY; y <= maxY; y++) {
                for (int x = minX; x <= maxX; x++) {
                    double b1 =
                            ((y - v3.y) * (v2.x - v3.x) + (v2.y - v3.y) * (v3.x - x)) / triangleArea;
                    double b2 =
                            ((y - v1.y) * (v3.x - v1.x) + (v3.y - v1.y) * (v1.x - x)) / triangleArea;
                    double b3 =
                            ((y - v2.y) * (v1.x - v2.x) + (v1.y - v2.y) * (v2.x - x)) / triangleArea;
                    if (b1 >= 0 && b1 <= 1 && b2 >= 0 && b2 <= 1 && b3 >= 0 && b3 <= 1) {
                        // z buffering
                        double depth = b1 * v1.z + b2 * v2.z + b3 * v3.z;
                        int zIndex = y * img.getWidth() + x;
                        if (zBuffer[zIndex] < depth) {
                            img.setRGB(x, y, getShade(t.color, angleCos).getRGB());
                            zBuffer[zIndex] = depth;
                        }
                    }
                }
            }

        }

        g2.drawImage(img, 0, 0, null);


    }

    public static Color getShade(Color color, double shade) {
        double redLinear = Math.pow(color.getRed(), 2.4) * shade;
        double greenLinear = Math.pow(color.getGreen(), 2.4) * shade;
        double blueLinear = Math.pow(color.getBlue(), 2.4) * shade;

        int red = (int) Math.pow(redLinear, 1/2.4);
        int green = (int) Math.pow(greenLinear, 1/2.4);
        int blue = (int) Math.pow(blueLinear, 1/2.4);

        return new Color(red, green, blue);
    }


}
