package main.Coding.Algorithms.Normal.BinaryTreePath_257;

import main.Coding.Lib.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LinearWay {
    public static void main(String[] args) {

    }
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> arr = new ArrayList<>();

        check(root,sb,list);
        return list;

    }
    public void check(TreeNode root,StringBuilder sb,List<String> list){
        if(root == null)return;
        int len = sb.length();
        sb.append(root.val);


        if(root.left == null && root.right == null){
            list.add(sb.toString());
        }
        else{
            sb.append("->");
            check(root.left,sb,list);
            check(root.right,sb,list);
        }

        sb.setLength(len);
    }
}
