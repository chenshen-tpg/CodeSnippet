package main.Coding.Algorithms.Normal.SumOfLeftLeaves_404;

import main.Coding.Lib.TreeNode;

public class AIVersion {
    int ans;
    public int sumOfLeftLeaves(TreeNode root) {
        ans = 0; // Important: reset before use!
        helper(root);
        return ans;
    }
    private void helper(TreeNode node) {
        if (node == null) return;
        if (node.left != null && node.left.left == null && node.left.right == null) {
            ans += node.left.val;
        }
        helper(node.left);
        helper(node.right);
    }
}
