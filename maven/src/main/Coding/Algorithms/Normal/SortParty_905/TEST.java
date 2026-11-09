package main.Coding.Algorithms.Normal.SortParty_905;

public class TEST {
    public static void main(String[] args) {

    }

    public int[] sortArrayByParity(int[] nums) {
        int [] memo = new int [nums.length];
        int index = 0, len = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                memo[index++] = nums[i];
            } else {
                memo[len--] = nums[i];
            }
        }
        return memo;
    }
}
