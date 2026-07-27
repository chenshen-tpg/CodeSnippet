package main.Coding.Algorithms.Normal.MaximumProduct_1464;

import java.util.Arrays;

public class TEST {

    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length - 1;
        return (nums[len] - 1) * (nums[len - 1] -1 );
    }
}
