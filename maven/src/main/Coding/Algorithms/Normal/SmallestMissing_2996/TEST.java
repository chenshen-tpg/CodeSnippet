package main.Coding.Algorithms.Normal.SmallestMissing_2996;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.missingInteger(new int [] {3,4,5,1,12,14,13});
    }

    public int missingInteger(int[] nums) {
        int n = nums.length;
        Set<Integer> numSet = new HashSet<>(n);
        for (int num : nums) {
            numSet.add(num);
        }
        int total = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                total += nums[i];
            } else {
                break;
            }
        }

        while (numSet.contains(total)) {
            total += 1;
        }

        return total;
    }
}
