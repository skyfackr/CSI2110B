package assignment.pa1;

import java.util.ArrayList;
import java.util.List;

public class PointCluster implements IPointCluster {
    private final List<IPoint3D> points;
    private final int clusterId;
    private final double r;
    private final double g;
    private final double b;

    public PointCluster(int clusterId, double r, double g, double b) {
        this.points = new ArrayList<>();
        this.clusterId = clusterId;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public static List<Double> assignNewRGB(List<IPointCluster> clusters) {
        List<Double> rgb = new ArrayList<>();
        do {
            double r = Math.random() * 255;
            double g = Math.random() * 255;
            double b = Math.random() * 255;
            boolean found = false;
            for (IPointCluster cluster : clusters) {
                if (cluster.getRGB().equals(String.format("%.1f,%.1f,%.1f", r, g, b))) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                rgb.add(r);
                rgb.add(g);
                rgb.add(b);
                break;
            }
        } while (true);
        return rgb;
    }

    public static int assignNewID(List<IPointCluster> clusters) {
        int id = 1;
        do {
            boolean found = false;
            for (IPointCluster cluster : clusters) {
                if (cluster.getClusterId() == id) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return id;
            }
            id++;
        } while (true);
    }

    @Override
    public void addPoint(IPoint3D point) {
        points.add(point);
        point.setCluster(clusterId);
    }

    @Override
    public List<IPoint3D> getPoints() {
        return points;
    }

    @Override
    public int getClusterId() {
        return clusterId;
    }

    @Override
    public String getRGB() {
        return String.format("%.1f,%.1f,%.1f", r, g, b);
    }

    @Override
    public boolean removePoint(IPoint3D point) {
        if (points.remove(point)) {
            point.setCluster(-1);
            return true;
        }
        return false;
    }
}
