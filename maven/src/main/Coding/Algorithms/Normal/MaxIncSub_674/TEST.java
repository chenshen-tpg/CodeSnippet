package main.Coding.Algorithms.Normal.MaxIncSub_674;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.findLengthOfLCIS(new int [] {1,3,5,4, 7});
    }
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) return nums[0];
        int ans = 0;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                max++;
            } else {
                max = 1;
            }
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
