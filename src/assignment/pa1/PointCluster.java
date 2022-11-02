package assignment.pa1;

import java.util.ArrayList;
import java.util.List;

public class PointCluster {
    private final List<IPoint3D> points;
    private final int clusterId;
    private final double r;
    private final double g;
    private final double b;
    public PointCluster( int clusterId, double r, double g, double b) {
        this.points = new ArrayList<>();
        this.clusterId = clusterId;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    public void addPoint(IPoint3D point) {
        points.add(point);
        point.setCluster(clusterId);
    }
    public List<IPoint3D> getPoints() {
        return points;
    }
    public int getClusterId() {
        return clusterId;
    }
    public String getRGB() {
        return String.format("%.1f,%.1f,%.1f", r , g , b );
    }
    public boolean removePoint(IPoint3D point) {
        if (points.remove(point)) {
            point.setCluster(-1);
            return true;
        }
        return false;
    }
}
