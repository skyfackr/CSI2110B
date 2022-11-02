package assignment.pa1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    private List<IPointCluster> clusters;
    public void findClusters()
    {
        clusters= new ArrayList<>();//initial ans list or erase previous answer

        INearestNeighbors neighborsFinder=new NearestNeighbors(points);
        for (IPoint3D current:points)
        {
            //single point processor
            if (current.getClusterID()!=-1)//processed and skip
                continue;
            List<IPoint3D> neighbors= neighborsFinder.rangeQuery(eps,current);//find neighbors
            if (neighbors.size()<minPts)//if not enough neighbors
            {
                for(IPoint3D noise:neighbors)
                {
                    noise.markNoise();//mark all neighbors as noise
                }
            }
            int id=PointCluster.assignNewID(this.clusters);
            List<Double> rgb=PointCluster.assignNewRGB(this.clusters);
            IPointCluster newCluster=new PointCluster(id,rgb.get(0),rgb.get(1),rgb.get(2));
            newCluster.addPoint(current);
            Stack<IPoint3D> pending=new Stack<>();
            pending.addAll(neighbors);//process neighbors
            while (!pending.isEmpty())
            {
                IPoint3D currentNeighbor=pending.pop();
                if (currentNeighbor.getClusterID()>=0)//processed and skip(dont skip noise)
                    continue;
                newCluster.addPoint(currentNeighbor);
                List<IPoint3D> neighborsOfNeighbor= neighborsFinder.rangeQuery(eps,currentNeighbor);//find neighbors
                if (neighborsOfNeighbor.size()>=minPts)//if enough neighbors
                {
                    pending.addAll(neighborsOfNeighbor);//process neighbors
                }
            }
        }
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
