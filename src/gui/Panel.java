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

    JButton pyramid, tetrahedron, tetrahedron_plane, cube, inflate;

    public Panel() {
        setBackground(Color.BLACK);
        mouseH = new MouseHandler(this);
        addMouseMotionListener(mouseH);
        addMouseWheelListener(mouseH);
        keyH = new KeyHandler(this);
        addKeyListener(keyH);
        setFocusable(true);

        pyramid = new JButton("Pyramid");
        pyramid.setBackground(Color.BLACK);
        pyramid.setForeground(Color.WHITE);
        pyramid.addActionListener(e -> {
            createPyramid();
            repaint();
        });
        add(pyramid);
        tetrahedron = new JButton("Tetrahedron");
        tetrahedron.setBackground(Color.BLACK);
        tetrahedron.setForeground(Color.WHITE);
        tetrahedron.addActionListener(e -> {
            createTetrahedron();
            repaint();
        });
        add(tetrahedron);
        tetrahedron_plane = new JButton("Tetrahedron with Plane");
        tetrahedron_plane.setBackground(Color.BLACK);
        tetrahedron_plane.setForeground(Color.WHITE);
        tetrahedron_plane.addActionListener(e -> {
            createTetrahedronWithOriginPlane();
            repaint();
        });
        add(tetrahedron_plane);
        cube = new JButton("Cube");
        cube.setBackground(Color.BLACK);
        cube.setForeground(Color.WHITE);
        cube.addActionListener(e -> {
            createCube();
            repaint();
        });
        add(cube);
        inflate = new JButton("Inflate");
        inflate.setBackground(Color.BLACK);
        inflate.setForeground(Color.WHITE);
        inflate.addActionListener(e -> {
            shape = inflate(shape);
            repaint();
        });
        add(inflate);
        pyramid.setFocusable(false);
        tetrahedron.setFocusable(false);
        tetrahedron_plane.setFocusable(false);
        cube.setFocusable(false);
        inflate.setFocusable(false);


        createTetrahedron();


    }


    public void createPyramid() {shape = new ArrayList<>();

// Base of the pyramid
        shape.add(new Triangle(
                new Vertex(-100, -100, -100),
                new Vertex(100, -100, -100),
                new Vertex(100, -100, 100),
                Color.RED
        ));
        shape.add(new Triangle(
                new Vertex(-100, -100, -100),
                new Vertex(100, -100, 100),
                new Vertex(-100, -100, 100),
                Color.RED
        ));

// Faces of the pyramid
        shape.add(new Triangle(
                new Vertex(-100, -100, -100),
                new Vertex(100, -100, -100),
                new Vertex(0, 100, 0),  // Apex of the pyramid
                Color.GREEN
        ));
        shape.add(new Triangle(
                new Vertex(100, -100, -100),
                new Vertex(100, -100, 100),
                new Vertex(0, 100, 0),  // Apex of the pyramid
                Color.BLUE
        ));
        shape.add(new Triangle(
                new Vertex(100, -100, 100),
                new Vertex(-100, -100, 100),
                new Vertex(0, 100, 0),  // Apex of the pyramid
                Color.YELLOW
        ));
        shape.add(new Triangle(
                new Vertex(-100, -100, 100),
                new Vertex(-100, -100, -100),
                new Vertex(0, 100, 0),  // Apex of the pyramid
                Color.MAGENTA
        ));
    }

    public void createCube() {
        shape = new ArrayList<>();

        // Front face
        shape.add(new Triangle(
                new Vertex(-100, -100, -100),
                new Vertex(100, -100, -100),
                new Vertex(100, 100, -100),
                Color.RED
        ));
        shape.add(new Triangle(
                new Vertex(-100, -100, -100),
                new Vertex(100, 100, -100),
                new Vertex(-100, 100, -100),
                Color.RED
        ));

        // Back face
        shape.add(new Triangle(
                new Vertex(-100, -100, 100),
                new Vertex(100, -100, 100),
                new Vertex(100, 100, 100),
                Color.BLUE
        ));
        shape.add(new Triangle(
                new Vertex(-100, -100, 100),
                new Vertex(100, 100, 100),
                new Vertex(-100, 100, 100),
                Color.BLUE
        ));

        // Left face
        shape.add(new Triangle(
                new Vertex(-100, -100, -100),
                new Vertex(-100, 100, -100),
                new Vertex(-100, 100, 100),
                Color.GREEN
        ));
        shape.add(new Triangle(
                new Vertex(-100, -100, -100),
                new Vertex(-100, 100, 100),
                new Vertex(-100, -100, 100),
                Color.GREEN
        ));

        // Right face
        shape.add(new Triangle(
                new Vertex(100, -100, -100),
                new Vertex(100, 100, -100),
                new Vertex(100, 100, 100),
                Color.YELLOW
        ));
        shape.add(new Triangle(
                new Vertex(100, -100, -100),
                new Vertex(100, 100, 100),
                new Vertex(100, -100, 100),
                Color.YELLOW
        ));

        // Top face
        shape.add(new Triangle(
                new Vertex(-100, 100, -100),
                new Vertex(100, 100, -100),
                new Vertex(100, 100, 100),
                Color.CYAN
        ));
        shape.add(new Triangle(
                new Vertex(-100, 100, -100),
                new Vertex(100, 100, 100),
                new Vertex(-100, 100, 100),
                Color.CYAN
        ));

        // Bottom face
        shape.add(new Triangle(
                new Vertex(-100, -100, -100),
                new Vertex(100, -100, -100),
                new Vertex(100, -100, 100),
                Color.MAGENTA
        ));
        shape.add(new Triangle(
                new Vertex(-100, -100, -100),
                new Vertex(100, -100, 100),
                new Vertex(-100, -100, 100),
                Color.MAGENTA
        ));

    }

    public void createTetrahedron() {
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

    public void createTetrahedronWithOriginPlane() {
        shape = new ArrayList<>();

        // Add tetrahedron vertices
        Vertex v1 = new Vertex(200, 200, 200);
        Vertex v2 = new Vertex(-200, -200, 200);
        Vertex v3 = new Vertex(-200, 200, -200);
        Vertex v4 = new Vertex(200, -200, -200);

        // Add tetrahedron triangles
        shape.add(new Triangle(v1, v2, v3, Color.YELLOW));
        shape.add(new Triangle(v1, v2, v4, Color.RED));
        shape.add(new Triangle(v3, v4, v1, Color.GREEN));
        shape.add(new Triangle(v3, v4, v2, Color.BLUE));

        // Add plane triangles (centered at the origin)
        double planeSize = 400; // Adjust the size of the plane as needed
        double halfPlaneSize = planeSize / 2;
        Vertex planeV1 = new Vertex(-halfPlaneSize, -halfPlaneSize, -200);
        Vertex planeV2 = new Vertex(halfPlaneSize, -halfPlaneSize, -200);
        Vertex planeV3 = new Vertex(halfPlaneSize, halfPlaneSize, -200);
        Vertex planeV4 = new Vertex(-halfPlaneSize, halfPlaneSize, -200);

        // Define two triangles to form the plane
        shape.add(new Triangle(planeV1, planeV2, planeV3, Color.WHITE));
        shape.add(new Triangle(planeV1, planeV3, planeV4, Color.WHITE));
    }



    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        double heading, pitch, roll;
        if(mouseInput) {
            heading = mouseH.getAngleX();
            pitch = mouseH.getAngleY();
            roll = mouseH.getAngleZ();
            keyH.setAngleX(heading);
            keyH.setAngleY(pitch);
            keyH.setAngleZ(roll);
        } else {
            heading = keyH.getAngleX();
            pitch = keyH.getAngleY();
            roll = keyH.getAngleZ();
            mouseH.setAngleX(heading);
            mouseH.setAngleY(pitch);
            mouseH.setAngleZ(roll);
        }

        /* XZ Rotation Matrix <Left and Right>
        |   cos(θ) 0   -sin(θ)  |
        |   0      1   0        |
        |   sin(θ) 0   cos(θ)   |
         */
        Matrix3 headingTransform = new Matrix3(new double[] {
                Math.cos(heading), 0, -Math.sin(heading),
                0, 1, 0,
                Math.sin(heading), 0, Math.cos(heading)
        });

        /* YZ Rotation Matrix <Up and Down>
        |   1       0           0       |
        |   0       cos(θ)      sin(θ)  |
        |   0       -sin(θ)     cos(θ)  |
         */
        Matrix3 pitchTransform = new Matrix3(new double[] {
                1, 0, 0,
                0, Math.cos(pitch), Math.sin(pitch),
                0, -Math.sin(pitch), Math.cos(pitch)
        });

        /* XY Rotation Matrix <Roll>
        |   cos(θ)  -sin(θ)     0       |
        |   sin(θ)  cos(θ)      0       |
        |   0       0           1       |
         */
        Matrix3 rollTransform = new Matrix3(new double[]  {
                Math.cos(roll), -Math.sin(roll), 0,
                Math.sin(roll), Math.cos(roll), 0,
                0, 0, 1
        });



        Matrix3 transform = headingTransform.multiply(pitchTransform);
        transform = transform.multiply(rollTransform);



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


    public static List<Triangle> inflate(List<Triangle> shape) {
        List<Triangle> result = new ArrayList<>();
        for (Triangle t : shape) {
            Vertex m1 =
                    new Vertex((t.v1.x + t.v2.x)/2, (t.v1.y + t.v2.y)/2, (t.v1.z + t.v2.z)/2);
            Vertex m2 =
                    new Vertex((t.v2.x + t.v3.x)/2, (t.v2.y + t.v3.y)/2, (t.v2.z + t.v3.z)/2);
            Vertex m3 =
                    new Vertex((t.v1.x + t.v3.x)/2, (t.v1.y + t.v3.y)/2, (t.v1.z + t.v3.z)/2);
            result.add(new Triangle(t.v1, m1, m3, t.color));
            result.add(new Triangle(t.v2, m1, m2, t.color));
            result.add(new Triangle(t.v3, m2, m3, t.color));
            result.add(new Triangle(m1, m2, m3, t.color));
        }
        for (Triangle t : result) {
            for (Vertex v : new Vertex[] { t.v1, t.v2, t.v3 }) {
                double l = Math.sqrt(v.x * v.x + v.y * v.y + v.z * v.z) / Math.sqrt(30000);
                v.x /= l;
                v.y /= l;
                v.z /= l;
            }
        }
        return result;
    }

}
