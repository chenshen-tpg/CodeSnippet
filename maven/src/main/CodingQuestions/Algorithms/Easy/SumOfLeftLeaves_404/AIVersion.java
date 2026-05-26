package main.CodingQuestions.Algorithms.Easy.SumOfLeftLeaves_404;

import main.CodingQuestions.Lib.TreeNode;

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
