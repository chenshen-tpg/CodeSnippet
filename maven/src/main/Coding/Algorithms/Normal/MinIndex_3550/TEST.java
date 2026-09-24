package main.Coding.Algorithms.Normal.MinIndex_3550;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.smallestIndex(new int [] {1,3,2});
    }

    public int smallestIndex(int[] nums) {
        int min = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int cur = 0;
            while (temp > 0) {
                cur += temp % 10;
                temp /= 10;
            }
            if (cur == start && cur < min) {
                min = cur;
            }
            start++;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
