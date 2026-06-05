package main.Coding.Algorithms.Normal.BinaryTreeInOrderTraversal_94;

import main.Coding.Lib.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BFS {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
