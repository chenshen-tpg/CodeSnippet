package main.CodingQuestions.Algorithms.Medium.TopKFrequentElements_347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BucketSort {
    /***
     Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

     Example 1:
     Input: nums = [1,1,1,2,2,3], k = 2
     Output: [1,2]

     Example 2:
     Input: nums = [1], k = 1
     Output: [1]

     Example 3:
     Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
     Output: [1,2]
     */

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        BucketSort obj = new BucketSort();
        System.out.println(obj.topKFrequent_BucketSort(nums, 2));
    }


    public List<Integer> topKFrequent_BucketSort(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> hm = new HashMap<>();
        for (int n : nums) {
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }
        for (int key : hm.keySet()) {
            int frequency = hm.get(key);
            if (bucket[frequency] == null) bucket[frequency] = new ArrayList();
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }
}
