package main.Coding.Algorithms.Normal.TransformedArr_3379;

public class SampleAnswer {
    public static void main(String[] args) {

    }
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[(((i + nums[i]) % n) + n) % n];
        }
        return res;
    }
}
