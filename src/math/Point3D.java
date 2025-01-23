package math;

public class Point3D {

    public double x, y, z;

    public Point3D() {
        x = 0;
        y = 0;
        z = 0;
    }

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3D(Point3D point) {
        // Copies the values of p into this Point3D
        x = point.x;
        y = point.y;
        z = point.z;
    }


    public Point3D add(Point3D point) {
        return new Point3D(x + point.x, y + point.y, z + point.z);
    }

    public Point3D subtract(Point3D point) {
        return new Point3D(x - point.x, y - point.y, z - point.z);
    }

    public Vector3D subtractVector(Point3D point) {
        return new Vector3D(x - point.x, y - point.y, z - point.z);
    }

    public Point3D multiply(double scalar) {
        return new Point3D(x * scalar, y * scalar, z * scalar);
    }

    public Point3D divide(double scalar) {
        return new Point3D(x / scalar, y / scalar, z / scalar);
    }

    public double dot(Point3D point) {
        return x*point.x + y*point.y + z*point.z;
    }
    public double dot(Vector3D vector) {
        return x*vector.x + y*vector.y + z*vector.z;
    }
    public double dot(Normal normal) {
        return x*normal.x + y*normal.y + z*normal.z;
    }




}
