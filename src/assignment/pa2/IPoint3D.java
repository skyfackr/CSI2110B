package assignment.pa2;

public interface IPoint3D {
    void setCluster(int cluster);

    double getX();

    double getY();

    double getZ();

    double distance(IPoint3D other);

    int getClusterID();

    void markNoise();
}
