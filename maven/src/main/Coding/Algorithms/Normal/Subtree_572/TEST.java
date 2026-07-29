package main.Coding.Algorithms.Normal.Subtree_572;

import main.Coding.Lib.TreeNode;

public class TEST {
    public static void main(String[] args) {

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (dfs(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    private boolean dfs(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == null && node2 == null;
        }
        return node1.val == node2.val && dfs(node1.left, node2.left) && dfs(node1.right, node2.right);
    }
}
