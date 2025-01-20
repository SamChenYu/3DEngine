package geometry;

import math.Color;
import math.Point3D;
import math.Ray;

public class Sphere extends GeometricObject {

    public Point3D center;
    public double radius;
    public Color color;

    public Sphere(Point3D center, double radius, Color color) {
        this.center = new Point3D(center);
        this.radius = radius;
        this.color = color;
    }

    public double hit(Ray ray) {
        /*  (p-c) * (p-c) = r^2
            (o+td-c) * (o+td-c) - r^2 = 0
            (d*d)t^2 + 2d(o-c)t + (o-c)*(o-c) - r^2 = 0
            Quadratic equation: at^2 + bt + c = 0
         */
        double a = ray.direction.dot(ray.direction);
        double b = 2 * ray.origin.subtract(center).dot(ray.direction);
        double c = ray.origin.subtract(center).dot(ray.origin.subtract(center)) - radius * radius;
        double discriminant = b*b-4*a*c;

        if(discriminant < 0.0) {
            return 0.0;
        } else {
            double t = (-b - Math.sqrt(discriminant)) / (2*a);
            if(t > 10E-9) {
                return t;
            } else {
                return 0.0;
            }
        }
    }

}
