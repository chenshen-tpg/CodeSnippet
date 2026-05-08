package CodingQuestions.Algorithms.Medium.BinaryTreeLevelOrderTraversal_102;

import CodingQuestions.Lib.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SampleAnswer {

    /***
     *
     Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
     Example 1:
     Input: root = [3,9,20,null,null,15,7]
     Output: [[3],[9,20],[15,7]]

     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> li = new ArrayList();
        if (root == null) return li;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            li.add(new ArrayList());
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.remove();
                li.get(level).add(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            level++;
        }
        return li;
    }
}
