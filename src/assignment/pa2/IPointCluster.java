package assignment.pa2;

import java.util.List;

public interface IPointCluster {
    void addPoint(IPoint3D point);

    List<IPoint3D> getPoints();

    int getClusterId();

    String getRGB();

    boolean removePoint(IPoint3D point);
}
