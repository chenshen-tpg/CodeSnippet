package CodingQuestions.Algorithms.Medium.LRUcache_146;

import java.util.HashMap;
import java.util.Map;

/***
 Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

 Implement the LRUCache class:

 LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 int get(int key) Return the value of the key if the key exists, otherwise return -1.
 void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
 If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 The functions get and put must each run in O(1) average time complexity.



 Example 1:

 Input
 ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 Output
 [null, null, null, 1, null, -1, null, -1, 3, 4]

 Explanation
 LRUCache lRUCache = new LRUCache(2);
 lRUCache.put(1, 1); // cache is {1=1}
 lRUCache.put(2, 2); // cache is {1=1, 2=2}
 lRUCache.get(1);    // return 1
 lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 lRUCache.get(2);    // returns -1 (not found)
 lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 lRUCache.get(1);    // return -1 (not found)
 lRUCache.get(3);    // return 3
 lRUCache.get(4);    // return 4



 */
class LRUCache {

    private Map<Integer, Node> map = new HashMap<>();
    private Node head, tail;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2); // Capacity of 2
        cache.put(1, 1); // Add key=1, value=1
        cache.put(2, 2); // Add key=2, value=2
        System.out.println(cache.get(1)); // Access key=1, should return 1
        cache.put(3, 3); // Add key=3, value=3, evicts key=2 (LRU)
        System.out.println(cache.get(2)); // Access key=2, should return -1 (not found)
        cache.put(4, 4); // Add key=4, value=4, evicts key=1 (LRU)
        System.out.println(cache.get(1)); // Access key=1, should return -1 (not found)
        System.out.println(cache.get(3)); // Access key=3, should return 3
        System.out.println(cache.get(4)); // Access key=4, should return 4
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            Node newNode = new Node();
            newNode.value = value;
            newNode.key = key;
            map.put(key, newNode);
            addNode(newNode);
            if (map.size() > capacity) {
                Node last = popTail();
                map.remove(last.key);
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }


    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }


    private Node popTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }

    class Node {
        int value;
        int key;
        Node prev;
        Node next;
    }
}


