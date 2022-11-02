package assignment.pa1;

import java.util.List;

public class NearestNeighbors implements INearestNeighbors {
    private final List<IPoint3D> lists;
    public NearestNeighbors(List<IPoint3D> lists) {
        this.lists = lists;
    }
    @Override
    public List<IPoint3D> rangeQuery(double eps, IPoint3D point) {
        //todo a rangeQuery method that finds the nearest neighbors of a 3D point
        throw new UnsupportedOperationException();
    }
}
