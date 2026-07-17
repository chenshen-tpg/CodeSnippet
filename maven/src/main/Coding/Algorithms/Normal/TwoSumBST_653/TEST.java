package main.Coding.Algorithms.Normal.TwoSumBST_653;

import main.Coding.Lib.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TEST {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode();
        node.right = new TreeNode(3);

        TEST test = new TEST();
        test.findTarget(node, 6);
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> li = new ArrayList();
        helper(root, li);
        int l = 0, r = li.size() - 1;
        while (l < r) {
            int sum = li.get(l) + li.get(r);
            if (sum == k) return true;
            if (sum < k) l++;
            else r--;
        }
        return false;
    }

    public void helper(TreeNode node, List<Integer> li) {
        if (node != null) {
            helper(node.left, li);
            li.add(node.val);
            helper(node.right, li);
        }
    }
}
