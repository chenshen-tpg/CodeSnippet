package main.CodingQuestions.Algorithms.Easy.ApplyOperationsToAnArray_2460;

public class mySolution {

    public static void main(String[] args) {
        mySolution obj = new mySolution();
        obj.applyOperations(new int[]{1, 2, 2, 1, 1, 0});
    }

    public int[] applyOperations(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                nums[i - 1] *= 2;
                nums[i] = 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = 0;
        }
        return nums;
    }
}
