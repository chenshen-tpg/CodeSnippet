package main.Coding.Algorithms.Normal.TwoSumBST_653;

import main.Coding.Lib.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class SampleSolution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet();
        return find(root, k, set);
    }

    public boolean find(TreeNode root, int k, Set<Integer> set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
}
