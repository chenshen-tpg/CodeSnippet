package main.Coding.Algorithms.Normal.GCD_1979;

public class TEST {
    public static void main(String[] args) {

    }
    public int findGCD(int[] nums) {
        int min = nums[0], max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return gcd (max, min);
    }

    public int gcd (int i, int j) {
        if (j == 0) return i;
        return gcd(j, i % j);
    }
}
