package main.CodingQuestions.Algorithms.Easy.MinCostCandy_2144;

import java.util.Arrays;

public class SampleSolution {
    public static void main(String[] args) {

    }

    public int minimumCost(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int i = nums.length - 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            sum = sum + nums[j];
            if (i - j == 2) {
                sum = sum - nums[j];
                i = i - 3;
            }
        }
        return sum;
    }
}
