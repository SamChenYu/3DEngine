package scene;

import geometry.GeometricObject;
import geometry.Plane;
import geometry.Sphere;
import math.Color;
import math.Normal;
import math.Point3D;

import java.util.ArrayList;
import java.util.List;

public class World {

    public ViewPlane viewPlane;
    public List<GeometricObject> objects;
    public Color background;

    public World(int width, int height, double size) {
        viewPlane = new ViewPlane(width, height, size);
        background = new Color(0.0F, 0.0F, 1.0F);
        objects = new ArrayList<>();
        objects.add(new Sphere(new Point3D(0.0, 0.0, 0.0), 60.0, new math.Color(1.0F, 0.0F, 0.0F)));
        objects.add(new Sphere(new Point3D(200.0, 0.0, 0.0), 30.0, new math.Color(0.0F, 1.0F, 0.0F)));
        objects.add(new Sphere(new Point3D(-200.0, 0.0, 0.0), 15.0, new math.Color(0.0F, 0.0F, 1.0F)));

        objects.add(new Plane(new Point3D(0.0, 0.0, 0.0), new Normal(0.0, 1.0, 0.2), new math.Color(1.0F, 0.0F, 1.0F)));
    }
}
