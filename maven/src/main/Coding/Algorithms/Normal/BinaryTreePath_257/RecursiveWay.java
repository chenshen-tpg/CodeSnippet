package main.Coding.Algorithms.Normal.BinaryTreePath_257;

import main.Coding.Lib.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RecursiveWay {
    public static void main(String[] args) {

    }
    List<String> li;
    public List<String> binaryTreePaths(TreeNode root) {
        li = new ArrayList();
        helper(root, "");
        return li;
    }
    public void helper(TreeNode node, String path) {
        if (node != null) {
            path += node.val + "";
            if (node.left == null && node.right == null) {
                li.add(path);
            } else {
                path += "->";
                helper(node.left, path);
                helper(node.right, path);
            }
        }
    }
}
