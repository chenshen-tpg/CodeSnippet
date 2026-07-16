package main.Coding.Algorithms.Medium.SumOfGCD_3867;

import java.util.Arrays;

public class TEST {
    public static void main(String[] args) {

    }

    public long gcdSum(int[] nums) {
        int len = nums.length;
        int [] memo = new int [len];
        int max = 0;
        for (int i =  0; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            memo[i] = gcd(max, nums[i]);
        }
        long ans = 0;
        int left = 0, right = len - 1;
        Arrays.sort(memo);
        while (left < right) {
            ans += gcd(memo[right], memo[left]);
            left++;
            right--;
        }
        return ans;
    }

    public int gcd (int i, int j) {
        if (j == 0) return i;
        return gcd (j, i % j);
    }
}
