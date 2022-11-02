package assignment.pa1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class DBSCAN {
    private final List<IPoint3D> points;
    private double eps;
    private double minPts;
    private List<IPointCluster> clusters;

    public DBSCAN(List<IPoint3D> points) {
        this.points = points;
    }

    public static List<IPoint3D> read(String filename) {
        List<IPoint3D> points = new ArrayList<>();
        List<String> lines;
        try {
            lines = Files.readAllLines(new File(filename).toPath());
        } catch (IOException e) {
            System.out.println("File read failed!");
            return null;
        }
        for (String line : lines) {
            if (line.startsWith("x"))
                continue;
            String[] parts = line.split(",");
            double x = Double.parseDouble(parts[0]);
            double y = Double.parseDouble(parts[1]);
            double z = Double.parseDouble(parts[2]);
            IPoint3D point = new Point3D(x, y, z);
            points.add(point);
        }
        return points;
    }

    public static void main(String[] args) {
        double minPts;
        double eps;
        String file;
        try {
            file = args[0];
            if (!Files.isRegularFile(Path.of(file))) {
                System.out.println("File not found!");
                return;
            }
            eps = Double.parseDouble(args[1]);
            minPts = Double.parseDouble(args[2]);
        } catch (Exception e) {
            System.out.println("[PARAMETER] FILENAME EPS MINPTS");
            return;
        }
        List<IPoint3D> points = DBSCAN.read(file);
        DBSCAN dbscan = new DBSCAN(points);
        dbscan.setEps(eps);
        dbscan.setMinPts(minPts);
        dbscan.findClusters();
        dbscan.save("%s_clusters_%.1f_%.0f_%d.csv".formatted(file.substring(0, file.lastIndexOf('.')), eps, minPts, dbscan.getNumberOfClusters()));
    }

    public void setEps(double eps) {
        this.eps = eps;
    }

    public void setMinPts(double minPts) {
        this.minPts = minPts;
    }

    public void findClusters() {
        clusters = new ArrayList<>();//initial ans list or erase previous answer

        INearestNeighbors neighborsFinder = new NearestNeighbors(points);
        for (IPoint3D current : points) {
            //single point processor
            if (current.getClusterID() != -1)//processed and skip
                continue;
            List<IPoint3D> neighbors = neighborsFinder.rangeQuery(eps, current);//find neighbors
            if (neighbors.size() < minPts)//if not enough neighbors
            {
                for (IPoint3D noise : neighbors) {
                    noise.markNoise();//mark all neighbors as noise
                }
                continue;
            }
            int id = PointCluster.assignNewID(this.clusters);
            List<Double> rgb = PointCluster.assignNewRGB(this.clusters);
            IPointCluster newCluster = new PointCluster(id, rgb.get(0), rgb.get(1), rgb.get(2));
            newCluster.addPoint(current);
            Stack<IPoint3D> pending = new Stack<>();
            pending.addAll(neighbors);//process neighbors
            while (!pending.isEmpty()) {
                IPoint3D currentNeighbor = pending.pop();
                if (currentNeighbor.getClusterID() >= 1)//processed and skip(dont skip noise)
                    continue;
                newCluster.addPoint(currentNeighbor);
                List<IPoint3D> neighborsOfNeighbor = neighborsFinder.rangeQuery(eps, currentNeighbor);//find neighbors
                if (neighborsOfNeighbor.size() >= minPts)//if enough neighbors
                {
                    pending.addAll(neighborsOfNeighbor);//process neighbors
                }
            }
            this.clusters.add(newCluster);
        }
    }

    public int getNumberOfClusters() {
        return clusters.size();
    }

    public List<IPoint3D> getPoints() {
        return points;
    }

    public void save(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            if (clusters.size() == 0)
                return;
            writer.write("x,y,z,C,R,G,B\n");//first line
            Map<Integer, String> RGBMap = new HashMap<>();//map cluster id to rgb string
            for (IPointCluster cluster : clusters) {
                RGBMap.put(cluster.getClusterId(), cluster.getRGB());
            }
            for (IPoint3D point3D : points) {
                if (point3D.getClusterID() == Point3D.NOISE)//noise writting
                {
                    writer.write(String.format("%.2f,%.2f,%.2f,0,0.0,0.0,0.0\n", point3D.getX(), point3D.getY(), point3D.getZ()));
                    continue;
                }
                writer.write(String.format("%.2f,%.2f,%.2f,%d,%s\n", point3D.getX(), point3D.getY(), point3D.getZ(), point3D.getClusterID(), RGBMap.get(point3D.getClusterID())));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
