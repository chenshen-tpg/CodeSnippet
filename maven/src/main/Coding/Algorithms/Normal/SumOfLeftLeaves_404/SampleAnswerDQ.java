package main.Coding.Algorithms.Normal.SumOfLeftLeaves_404;

import main.Coding.Lib.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SampleAnswerDQ {
    public static void main(String[] args) {

    }
    public int sumOfLeftLeaves(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.left != null) {
                if (cur.left.left == null && cur.left.right == null) {
                    ans += cur.left.val;
                }
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
        return ans;
    }
}
