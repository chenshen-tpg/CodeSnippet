package main.Coding.Algorithms.Normal.SmallerThanCur_1365;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.smallerNumbersThanCurrent(new int [] {8,1,2,2,3});
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int [] memo = new int [nums.length];
        for (int i = 0; i < nums.length; i++) {
            int cur = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] > nums[j]) {
                    cur++;
                }
            }
            memo[i] = cur;
        }
        return memo;
    }
}
