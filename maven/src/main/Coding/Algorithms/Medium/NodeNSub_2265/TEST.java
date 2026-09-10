package main.Coding.Algorithms.Medium.NodeNSub_2265;

import main.Coding.Lib.TreeNode;

public class TEST {
    int ans = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(6);

        TEST test = new TEST();
        int result = test.averageOfSubtree(root);
        System.out.println(result); // Expected: 5
    }


    public int averageOfSubtree(TreeNode root) {
        if (root != null) {
            averageOfSubtree(root.left);
            int [] a = new int[2];
            TreeNode cur = root;
            helper(cur,a);
            if (a[0]/a[1] == root.val) {
                ans++;
            }
            averageOfSubtree(root.right);
        }
        return ans;
    }

    public int[] helper (TreeNode node, int [] a) {
        if (node != null) {
            a[0] += node.val;
            a[1]++;
            helper(node.left, a);
            helper(node.right, a);
        }
        return a;
    }
}
