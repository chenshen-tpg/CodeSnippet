package main.CodingQuestions.Algorithms.Medium.TwoSumBSTs_1214;

import main.CodingQuestions.Lib.TreeNode;

public class MorrisTraversal {


    public static void main(String[] args) {

    }

    void morrisTraversal(TreeNode node) {
        TreeNode current = node;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.val + " ");
                current = current.right;
            } else {
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;
                    System.out.print(current.val + " ");
                    current = current.right;
                }
            }
        }
    }
}
