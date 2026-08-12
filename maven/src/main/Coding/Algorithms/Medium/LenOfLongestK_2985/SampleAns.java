package main.Coding.Algorithms.Medium.LenOfLongestK_2985;

import java.util.HashMap;

public class SampleAns {
    public static void main(String[] args) {

    }
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap();
        int ans = 0, start = -1;
        for (int i = 0; i < nums.length; i++) {
            int temp = hm.getOrDefault(nums[i], 0) + 1;
            hm.put(nums[i], temp);
            while (hm.get(nums[i]) > k) {
                start++;
                hm.put(nums[start], hm.get(nums[start]) - 1);
            }
            ans = Math.max(ans, i - start);
        }
        return ans;
    }
}
