package math;

public class Vertex {
    public double x;
    public double y;
    public double z;

    public double xNorm;
    public double yNorm;
    public double zNorm;

    public Vertex(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vertex(double x, double y, double z, double xNorm, double yNorm, double zNorm) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.xNorm = xNorm;
        this.yNorm = yNorm;
        this.zNorm = zNorm;
    }

    public void setNormal(double xNorm, double yNorm, double zNorm) {
        this.xNorm = xNorm;
        this.yNorm = yNorm;
        this.zNorm = zNorm;
    }

    public static Vertex dot(Vertex a, Vertex b) {
        return new Vertex(
                a.x * b.x,
                a.y * b.y,
                a.z * b.z);
    }
}