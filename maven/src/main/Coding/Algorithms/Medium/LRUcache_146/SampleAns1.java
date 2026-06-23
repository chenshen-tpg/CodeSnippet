package main.Coding.Algorithms.Medium.LRUcache_146;

import main.Coding.Lib.Node;

import java.util.HashMap;

public class SampleAns1 {
    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public static void main(String[] args) {
        SampleAns1 lruCache = new SampleAns1(2);
        lruCache.put(1, 1); // Cache: {1=1}
        lruCache.put(2, 2); // Cache: {1=1, 2=2}
        System.out.println(lruCache.get(1)); // Output: 1, Cache: {2=2, 1=1}
        lruCache.put(3, 3); // Cache: {1=1, 3=3} (2 is evicted)
        System.out.println(lruCache.get(2)); // Output: -1 (not found)
        lruCache.put(4, 4); // Cache: {3=3, 4=4} (1 is evicted)
        System.out.println(lruCache.get(1)); // Output: -1 (not found)
        System.out.println(lruCache.get(3)); // Output: 3, Cache: {4=4, 3=3}
        System.out.println(lruCache.get(4)); // Output: 4, Cache: {3=3, 4=4}
    }


    public SampleAns1(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            insert(node);
        } else {
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insert(newNode);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
