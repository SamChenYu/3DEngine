package gui;

import math.*;
import geometry.*;

import java.util.ArrayList;
import java.util.List;


public class Scene {

    List<GeometricObject> objects = new ArrayList<>();

    public Scene() {
        Sphere sphere = new Sphere(
                new Point3D(0.0, 0.0, 0.0),
                60.0,
                new Color(1.0F, 0.0F, 0.0F)
        );
        objects.add(sphere);
    }
}
