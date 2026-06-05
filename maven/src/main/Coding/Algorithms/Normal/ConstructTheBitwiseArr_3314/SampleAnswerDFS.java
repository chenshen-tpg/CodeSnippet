package main.Coding.Algorithms.Normal.ConstructTheBitwiseArr_3314;

import main.Coding.Lib.TreeNode;

public class SampleAnswerDFS {
    public static void main(String[] args) {

    }
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int current) {
        if (node == null) {
            return 0;
        }

        current = (current << 1) | node.val;

        if (node.left == null && node.right == null) {
            return current;
        }

        return dfs(node.left, current) + dfs(node.right, current);
    }
}
