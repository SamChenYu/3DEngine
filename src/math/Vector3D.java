package math;

public class Vector3D {


    public double x, y, z;

    public Vector3D() {
        x = 0;
        y = 0;
        z = 0;
    }

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D(Vector3D vector) {
        // Copies the values of v into this Vector3D
        x = vector.x;
        y = vector.y;
        z = vector.z;
    }

    public Vector3D add(Vector3D vector) {
        return new Vector3D(x + vector.x, y + vector.y, z + vector.z);
    }

    public Vector3D subtract(Vector3D vector) {
        return new Vector3D(x - vector.x, y - vector.y, z - vector.z);
    }

    public double dot(Vector3D vector) {
        return x*vector.x + y*vector.y + z*vector.z;
    }

    public double dot(Point3D point) {
        return x*point.x + y*point.y + z*point.z;
    }

    public double dot(Normal normal) {
        return x*normal.x + y*normal.y + z*normal.z;
    }

    public void normalize() {
        // Normalizes to unit vector
        double length = Math.sqrt(x*x + y*y + z*z);
        x /= length;
        y /= length;
        z /= length;
    }

    public Vector3D cross(Vector3D vector) {
        return new Vector3D(
                y*vector.z-z*vector.y,
                z*vector.x-x*vector.z,
                x*vector.y-y*vector.x
        );
    }

    public Vector3D mult(double scalar) {
        return new Vector3D(x*scalar, y*scalar, z*scalar);
    }

}
