package assignment.pa1;

import java.util.List;

public class DBSCAN {
    private final List<IPoint3D> points;
    public DBSCAN(List<IPoint3D> points) {
        this.points = points;
    }
    private double eps;
    private double minPts;
    public void setEps(double eps) {
        this.eps = eps;
    }
    public void setMinPts(double minPts) {
        this.minPts = minPts;
    }
    public void findClusters()
    {
        //todo execute algorithm
        throw new UnsupportedOperationException();
    }
    public int getNumberOfClusters()
    {
        //todo return the number of clusters
        throw new UnsupportedOperationException();
    }
    public List<IPoint3D> getPoints()
    {
        return  points;
    }
    public static List<Point3D> read(String filename)
    {
        //todo read the file and return a list of points
        throw new UnsupportedOperationException();
    }
    public void save(String filename)
    {
        //todo save the points to a file
        throw new UnsupportedOperationException();
    }
}
