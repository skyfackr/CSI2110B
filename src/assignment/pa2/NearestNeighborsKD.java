package assignment.pa2;

import java.util.ArrayList;
import java.util.List;

public class NearestNeighborsKD implements INearestNeighbors {
    protected KDTree tree;

    // construct with list of points
    public NearestNeighborsKD(List<Point3D> points) {
        this.tree = new KDTree();
        //List<Point3D> neighbors;
        for (Point3D p : points) {
            this.tree.add(p); // the add method should call the
// insert method given in pseudo-code
        }
// plus possibly other initializations
    }

    public List<Point3D> rangeQuery(Point3D p, double eps) {
        List<Point3D> neighbors= new ArrayList<Point3D>();
        rangeQuery(p, eps, neighbors, tree.getRoot());
        return neighbors;
    }
    private void rangeQuery(Point3D p, double eps, List<Point3D> neighbors, KDTree.KDTreeNode node) {
        if (node == null) {
            return;
        }
        if (p.distance(node.point) < eps) {
            neighbors.add(node.point);
        }
        if (p.get(node.axis) -eps<= node.value) {
            rangeQuery(p, eps, neighbors, node.left);
        }
        if (p.get(node.axis) +eps> node.value) {
            rangeQuery(p, eps, neighbors, node.right);
        }
    }
}
