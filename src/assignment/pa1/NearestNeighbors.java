package assignment.pa1;

import java.util.ArrayList;
import java.util.List;

public class NearestNeighbors implements INearestNeighbors {
    private final List<IPoint3D> lists;

    public NearestNeighbors(List<IPoint3D> lists) {
        this.lists = lists;
    }

    @Override
    public List<IPoint3D> rangeQuery(double eps, IPoint3D point) {
        List<IPoint3D> neighbors = new ArrayList<>();
        for (IPoint3D p : lists) {
            if (p.distance(point) <= eps) {
                neighbors.add(p);
            }
        }
        return neighbors;
    }
}
