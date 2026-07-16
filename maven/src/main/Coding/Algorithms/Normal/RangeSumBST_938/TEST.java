package main.Coding.Algorithms.Normal.RangeSumBST_938;

import main.Coding.Lib.TreeNode;

public class TEST {

    public static void main(String[] args) {

    }


    int ans;
    public int rangeSumBST(TreeNode root, int low, int high) {
        ans = 0;
        helper(root, low, high);
        return ans;
    }

    public void helper(TreeNode node, int low, int high) {
        if (node != null) {
            helper(node.left, low, high);
            if (node.val >= low && node.val <= high) {
                ans += node.val;
            }
            helper(node.right, low, high);
        }
    }
}
