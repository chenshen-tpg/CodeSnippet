package main.Coding.Algorithms.Normal.TwoSumLess_1099;

public class TEST2 {
    public static void main(String[] args) {

    }
    public int twoSumLessThanK(int[] nums, int k) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] < k && nums[i] + nums[j] > max) {
                    max = nums[i] + nums[j];
                }
            }
        }
        return max == 0 ? -1 : max;
    }
}
