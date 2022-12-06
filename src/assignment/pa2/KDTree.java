package assignment.pa2;

import assignment.pa2.Point3D;

import java.util.List;

public class KDTree {
    protected static int DIMENSION = 3;
    private KDTreeNode root;

    public KDTree() {
        root = null;
    }
    public static class KDTreeNode
    {
        public final Point3D point;
        public KDTreeNode left;
        public KDTreeNode right;
        public final int axis;
        public final double value;

        public KDTreeNode(Point3D point, int axis) {
            this.point = point;
            this.axis = axis;
            this.value = point.get(axis);
            left=right=null;
        }
    }
}
