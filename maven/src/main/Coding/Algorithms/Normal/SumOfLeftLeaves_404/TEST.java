package main.Coding.Algorithms.Normal.SumOfLeftLeaves_404;


import main.Coding.Lib.TreeNode;

public class TEST {
    public static void main(String[] args) {

    }
    public int sumLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        if (root.left == null) {
            ans += root.val;
        }
        sumLeftLeaves(root.left);
        sumLeftLeaves(root.right);
        return ans;
    }
}
