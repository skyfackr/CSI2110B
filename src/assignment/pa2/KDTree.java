/*
 * Copyright (c) 2022.
 * Sky Jiang 300217544
 */

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
        root=insertInternal(root,p ,0);
        return root;
    }
    private KDTreeNode insertInternal(KDTreeNode node, Point3D p, int depth) {
        if (node == null) {
            node=new KDTreeNode(p, depth );
        }
        else if (p.get(node.axis) <= node.value) {
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
