package math;

public class Normal {
    // For lighting and ray intersections

    public double x,y,z;

    public Normal() {
        x = 0.0;
        y = 0.0;
        z = 0.0;
    }

    public Normal(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Normal(Normal n) {
        x = n.x;
        y = n.y;
        z = n.z;
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



}
