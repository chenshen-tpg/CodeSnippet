package main.Coding.Algorithms.Normal.SequentialPrefix_2996;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TEST {
    public static void main(String[] args) {
        int [] arr = new int [] {1,2,3,2,5};
        TEST test = new TEST();
        test.missingInteger(arr);
    }

    public int missingInteger(int[] nums) {
        int sum = nums[0];
        int i = 1;
        while (i < nums.length && nums[i] == nums[i - 1] + 1) {
            sum += nums[i];
            i++;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        while (set.contains(sum)) {
            sum++;
        }
        return sum;

    }
}
