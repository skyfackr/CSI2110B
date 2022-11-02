package assignment.pa1;

import java.util.List;

public interface INearestNeighbors {
    List<IPoint3D> rangeQuery(double eps, IPoint3D point);
}
