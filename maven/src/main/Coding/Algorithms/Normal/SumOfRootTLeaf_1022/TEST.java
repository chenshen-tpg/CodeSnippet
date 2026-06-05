package main.Coding.Algorithms.Normal.SumOfRootTLeaf_1022;

import main.Coding.Lib.TreeNode;

public class TEST {
    int ans = 0;
    String curVal = "";

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        TEST test = new TEST();
        System.out.println(test.sumRootToLeaf(root));
    }

    public int sumRootToLeaf(TreeNode root) {
        helper(root);
        return ans;
    }

    public void helper(TreeNode node) {
        if (node == null) return;
        curVal += String.valueOf(node.val);
        if (node.left == null && node.right == null) {
            ans += Integer.parseInt(curVal, 2);
            curVal = curVal.substring(0, curVal.length() - 1);
            return;
        }
        helper(node.left);
        helper(node.right);
        curVal = curVal.substring(0, curVal.length() - 1);
    }
}
