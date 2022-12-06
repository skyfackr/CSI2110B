package assignment.pa2;

public class KDTree {
    protected static int DIMENSION = 3;
    private KDTreeNode root;

    public KDTree() {
        root = null;
    }

    public KDTreeNode getRoot() {
        return root;
    }

    public KDTreeNode add(Point3D p) {
        return insertInternal(root,p ,0);
    }
    private KDTreeNode insertInternal(KDTreeNode node, Point3D p, int depth) {
        if (node == null) {
            return new KDTreeNode(p, depth );
        }
        if (p.get(node.axis) <= node.value) {
            node.left = insertInternal(node.left, p, (depth + 1)% DIMENSION);
        } else {
            node.right = insertInternal(node.right, p, (depth + 1)% DIMENSION);
        }
        return node;
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
