package main.Coding.Lib;

public class Node {
    public int key;
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node prev;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _key, int _val) {
        key = _key;
        val = _val;
    }
    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

}
