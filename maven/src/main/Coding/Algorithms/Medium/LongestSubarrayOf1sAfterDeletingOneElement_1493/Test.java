package main.Coding.Algorithms.Medium.LongestSubarrayOf1sAfterDeletingOneElement_1493;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 0, 1, 1, 1, 0, 1};
        int k = 2;
        System.out.println(method(nums , 2));
    }

    public static int method(int[] nums, int k) {
        int ans = 0;
        int index = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }
            while (count > k) {
                if (nums[index] == 1) {
                    index++;
                } else {
                    count--;
                    index++;
                }
            }
            ans = Math.max(ans, i - index);
        }
        return ans;
    }
}
