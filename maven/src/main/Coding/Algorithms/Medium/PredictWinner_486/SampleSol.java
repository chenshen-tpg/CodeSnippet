package main.Coding.Algorithms.Medium.PredictWinner_486;

public class SampleSol {
    public static void main(String[] args) {
        SampleSol test = new SampleSol();
        test.predictTheWinner(new int [] {1,5,233,7});
    }

    private int maxDiff(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int scoreByLeft = nums[left] - maxDiff(nums, left + 1, right);
        int scoreByRight = nums[right] - maxDiff(nums, left, right - 1);

        return Math.max(scoreByLeft, scoreByRight);
    }

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        return maxDiff(nums, 0, n - 1) >= 0;
    }
}
