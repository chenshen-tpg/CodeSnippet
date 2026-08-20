package main.Coding.Algorithms.Medium.LenOfLongestK_2985;

import java.util.HashMap;

public class TEST {

    public static void main(String[] args) {
        TEST test = new TEST();
        test.maxSubarrayLength(new int [] {2,2,3}, 1);
    }

    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int newCount = hm.getOrDefault(nums[j], 0) + 1;
                hm.put(nums[j], newCount);
                if (newCount > k) {
                    break;
                }
                ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}
