package main.Coding.Algorithms.Normal.TwoSumLess_1099;

import java.util.Arrays;

public class TEST {
    public static void main(String[] args) {

    }
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int max = -1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum >= k) {
                r--;
            } else {
                max = Math.max(max, sum);
                l++;
            }
        }
        return max;
    }
}
