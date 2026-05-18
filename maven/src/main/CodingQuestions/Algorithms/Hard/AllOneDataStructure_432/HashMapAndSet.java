package main.CodingQuestions.Algorithms.Hard.AllOneDataStructure_432;

import main.CodingQuestions.Lib.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/***

 432. All O`one Data Structure
 Design a data structure to store the strings' count with the ability to return the strings with minimum and maximum counts.

 Implement the AllOne class:
 AllOne() Initializes the object of the data structure.
 inc(String key) Increments the count of the string key by 1. If key does not exist in the data structure, insert it with count 1.
 dec(String key) Decrements the count of the string key by 1. If the count of key is 0 after the decrement, remove it from the data structure. It is guaranteed that key exists in the data structure before the decrement.
 getMaxKey() Returns one of the keys with the maximal count. If no element exists, return an empty string "".
 getMinKey() Returns one of the keys with the minimum count. If no element exists, return an empty string "".
 Note that each function must run in O(1) average time complexity.



 Example 1:

 Input
 ["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"]
 [[], ["hello"], ["hello"], [], [], ["leet"], [], []]
 Output
 [null, null, null, "hello", "hello", null, "hello", "leet"]

 Explanation
 AllOne allOne = new AllOne();
 allOne.inc("hello");
 allOne.inc("hello");
 allOne.getMaxKey(); // return "hello"
 allOne.getMinKey(); // return "hello"
 allOne.inc("leet");
 allOne.getMaxKey(); // return "hello"
 allOne.getMinKey(); // return "leet"
 *
 *
 *
 */
public class HashMapAndSet {
    private Map<String, Integer> count;
    private TreeSet<Pair<Integer, String>> set;

    public HashMapAndSet() {
        count = new HashMap<>();
        set = new TreeSet<>((a, b) -> a.getKey().equals(b.getKey()) ? a.getValue().compareTo(b.getValue()) : a.getKey().compareTo(b.getKey()));
    }

    public static void main(String[] args) {

    }

    public void inc(String key) {
        int n = count.getOrDefault(key, 0);
        count.put(key, n + 1);
        set.remove(new Pair<>(n, key));
        set.add(new Pair<>(n + 1, key));
    }

    public void dec(String key) {
        int n = count.get(key);
        set.remove(new Pair<>(n, key));
        if (n == 1) {
            count.remove(key);
        } else {
            count.put(key, n - 1);
            set.add(new Pair<>(n - 1, key));
        }
    }

    public String getMaxKey() {
        return set.isEmpty() ? "" : set.last().getValue();
    }

    public String getMinKey() {
        return set.isEmpty() ? "" : set.first().getValue();
    }
}
