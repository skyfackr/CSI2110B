package assignment.pa2;

import java.util.List;

public interface INearestNeighbors {
    // gets the neighbors of p (at a distance less than eps)
    List<Point3D> rangeQuery(Point3D p, double eps);
}
