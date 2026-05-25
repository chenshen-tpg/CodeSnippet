package main.CodingQuestions.Algorithms.Easy.SetMismatch_645;

import java.util.Arrays;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.findErrorNums(new int [] {1,1});
    }
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int rep = 0;
        int cur = 1;
        int loss = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                rep = nums[i];
            }
            if (cur != nums[i]) {
                loss = cur;
            }
            if (i == nums.length - 1 && loss == 1) {
                loss++;
            }
        }
        return new int [] {rep, loss};
    }
}
