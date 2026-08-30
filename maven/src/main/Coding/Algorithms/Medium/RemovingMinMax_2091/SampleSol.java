package main.Coding.Algorithms.Medium.RemovingMinMax_2091;

public class SampleSol {
    public static void main(String[] args) {

    }

    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, maxpo = 0;
        int min = Integer.MAX_VALUE, minpo = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > max) {
                max = nums[i];
                maxpo = i;
            }
            if (nums[i] < min) {
                min = nums[i];
                minpo = i;
            }
        }
        int l = Math.min(minpo, maxpo);
        int r = Math.max(minpo, maxpo);
        return Math.min(Math.min(r + 1, n - l), l + 1 + n - r);
    }
}
