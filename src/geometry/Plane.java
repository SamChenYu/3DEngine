package geometry;

import math.Color;
import math.Normal;
import math.Point3D;
import math.Ray;

public class Plane {

    Point3D point;
    Normal normal;
    Color color;



    public Plane(Point3D point, Normal normal, Color color) {
        this.point = new Point3D(point);
        this.normal = new Normal(normal);
        this.color = color;
    }

    public double hit(Ray ray) {

        // Definition of plane: (p-a)*n=0
        // for all points p on the plane
        // n is the normal vector to the plane
        // a is a point on the plane

        /*
        (p-a)*n=0
        (o+td-a)*n=0 // o is the origin of the ray, d is the direction of the ray
        o*n + td*n - a*n = 0
        td*n + (a-o)*n = 0
        t = (a-o)*n/d*n
         */

        double t = point.subtract(ray.origin).dot(normal) / ray.direction.dot(normal);
        if (t > 10E-9) {
            // If t is very close to 0, we consider it to be 0
            // If t is not zero -> then we can say that the ray intersects the plane
            return t;
        } else {
            return 0.0;
        }
    }

}
