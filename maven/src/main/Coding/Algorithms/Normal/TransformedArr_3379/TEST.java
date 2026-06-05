package main.Coding.Algorithms.Normal.TransformedArr_3379;

import java.util.Arrays;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.constructTransformedArray(new int [] {3,-2,1,1});
    }
    public int[] constructTransformedArray(int[] nums) {
        boolean [] memo = new boolean[nums.length];
        Arrays.fill(memo, true);
        int left = 0, right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && memo[i] == true && memo[right] == true) {
                int temp = nums[right];
                nums[right] = nums[i];
                right--;
                nums[i] = temp;
                memo[i] = false;
                memo[right] = false;
            } else if (nums[i] < 0 && memo[i] == true && memo[left] == true) {
                int temp = nums[left];
                nums[left] = left;
                left++;
                nums[i] = temp;
                memo[i] = false;
                memo[left] = false;
            }
        }
        return nums;
    }
}
