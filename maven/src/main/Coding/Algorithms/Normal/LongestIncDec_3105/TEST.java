package main.Coding.Algorithms.Normal.LongestIncDec_3105;

public class TEST {
    public static void main(String[] args) {

    }

    public int longestMonotonicSubarray(int[] nums) {
        int max = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int temp = 1;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > nums[j-1]) {
                    temp++;
                } else {
                    break;
                }
            }
            max = Math.max(max, temp);
        }
        for (int i = 0; i < len; i++) {
            int temp = 1;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[j-1]) {
                    temp++;
                } else {
                    break;
                }
            }
            max = Math.max(max, temp);
        }
        return max;
    }
}
