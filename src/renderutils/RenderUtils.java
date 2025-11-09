package renderutils;

import math.*;
import java.util.ArrayList;
import java.util.List;

import java.awt.*;

public class RenderUtils {




    public static ArrayList<Triangle> createPyramid() {
        ArrayList<Triangle> shape = new ArrayList<>();
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
        return shape;
    }

    public static ArrayList<Triangle> createCube() {
        ArrayList<Triangle> shape = new ArrayList<>();

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
        return shape;
    }

    public static ArrayList<Triangle> createTetrahedron() {
        ArrayList<Triangle> shape = new ArrayList<>();
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
        return shape;
    }

    public static ArrayList<Triangle> createTetrahedronWithOriginPlane() {
        ArrayList<Triangle> shape = new ArrayList<>();

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

        return shape;
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