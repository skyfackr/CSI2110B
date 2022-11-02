package assignment.pa1;

public class Point3D implements IPoint3D {
    public static final int NOISE = 0;
    private final double x;
    private final double y;
    private final double z;
    private int cluster;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.cluster = -1;//-1 means no cluster
    }

    public Point3D(double x, double y, double z, int cluster) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.cluster = cluster;
    }

    @Override
    public void setCluster(int cluster) {
        this.cluster = cluster;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getZ() {
        return z;
    }

    @Override
    public double distance(IPoint3D other) {
        double xDiff = this.x - other.getX();
        double yDiff = this.y - other.getY();
        double zDiff = this.z - other.getZ();
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff + zDiff * zDiff);
    }

    @Override
    public int getClusterID() {
        return cluster;
    }

    @Override
    public void markNoise() {
        cluster = NOISE;
    }
}
