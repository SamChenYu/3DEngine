package scene;

import math.Point2D;
import math.Point3D;
import math.Ray;
import math.Vector3D;

public class PerspectiveProjection {
    // For PerspectiveProjection rendering
    public Point3D eye;
    public Point3D lookAt;
    public double distance;
    public Vector3D u, v, w; // orthonormal basis - new coordinate system for the camera

    public PerspectiveProjection(Point3D eye, Point3D lookAt, double FOV, int WIDTH, int HEIGHT) {
        this.eye = new Point3D(eye);
        this.lookAt = new Point3D(lookAt);
        this.distance = HEIGHT/2/Math.tan(Math.toRadians(FOV)); // tan(theta) = height/2/distance
        // Compute orthonormal basis
        compute_uvw();
    }

    public void compute_uvw() {
        w = eye.subtractVector(lookAt);
        w.normalize();

        Vector3D up = new Vector3D(0.00424, 1.0, 0.00764); // arbitrary up vector -> don't need perfectly pointed up

        u = up.cross(w);
        u.normalize();

        v = w.cross(u);
        v.normalize();
    }

    public Ray createRay(Point2D point) {
        // Basically converting coordinates to orthonormal basis
        Ray ray = new Ray(
            new Point3D(eye), u.mult(point.x).add(v.mult(point.y).subtract(w.mult(-distance)))
        );
        ray.direction.normalize();
        return ray;
    }

}
