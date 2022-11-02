package assignment.pa1;

public class Point3D {
    private final double x;
    private final double y;
    private final double z;
    private int cluster;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.cluster = -1;
    }
    public void setCluster(int cluster) {
        this.cluster = cluster;
    }
    public Point3D(double x, double y, double z, int cluster) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.cluster = cluster;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double distance(Point3D other) {
        double xDiff = this.x - other.x;
        double yDiff = this.y - other.y;
        double zDiff = this.z - other.z;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff + zDiff * zDiff);
    }

    public int getClusterID() {
        return cluster;
    }
}
