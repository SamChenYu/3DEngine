package geometry;

import math.Color;
import math.Ray;

public abstract class GeometricObject {
    public Color color;
    public abstract double hit(Ray ray);
}
