package main.Coding.Algorithms.Normal.BinaryTreeInOrder_94;

import main.Coding.Lib.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Test {
    List<Integer> li = new ArrayList();

    public List<Integer> inorderTraversal(TreeNode root) {
        helper(root);
        return li;
    }

    public void helper(TreeNode cur) {
        if (cur == null) return;
        helper(cur.left);
        li.add(cur.val);
        helper(cur.right);
    }
}
