package main.Coding.Algorithms.Medium.CountGoodNodesInBinaryTree_1448;

import main.Coding.Lib.TreeNode;

public class SampleAns1 {
    int count = 0;

    public static void main(String[] args) {

    }

    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return count;
    }
    //?? larger than the current value and update
// need question
    public void helper(TreeNode root, int cur) {
        if (root == null) return;
        if (root.val >= cur) count++;
        helper(root.left, Math.max(cur, root.val));
        helper(root.right, Math.max(cur, root.val));
    }
}
