package main.Coding.Algorithms.Medium.AdajacentIncreaseingSubArr_3350;

import java.util.Arrays;
import java.util.List;

public class TEST {
    public static void main(String[] args) {
        TEST obj = new TEST();
        obj.maxIncreasingSubarrays(Arrays.asList(4,4,5,6,7));
    }

    public int maxIncreasingSubarrays(List<Integer> nums) {
        int ans = 0;
        int len = nums.size();
        int increase = 1;
        int count = 0;
        for (int i = 1; i < len; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                increase++;
            } else {
                count = increase;
                increase = 1;
            }
            ans = Math.max(ans, Math.min(count, increase));
            ans = Math.max(ans, increase / 2);
        }

        return ans;
    }
}
