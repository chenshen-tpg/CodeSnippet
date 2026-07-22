package main.Coding.Algorithms.Normal.MinimalVal_1413;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        System.out.println(test.helper(new int[] {1, -2, -3}));
    }

    public int helper(int[] arr) {
        int prefix = 0;
        int minPrefix = 0;
        for (int num : arr) {
            prefix += num;
            minPrefix = Math.min(minPrefix, prefix);
        }
        return Math.max(1, 1 - minPrefix);
    }
}
