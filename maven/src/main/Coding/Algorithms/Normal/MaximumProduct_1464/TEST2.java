package main.Coding.Algorithms.Normal.MaximumProduct_1464;

import java.util.Arrays;

public class TEST2 {
    public static void main(String[] args) {
        TEST2 test = new TEST2();
        test.maxProduct(new int [] {1,5,4,5});
    }

    public int maxProduct(int[] nums) {
        int f = 0, s = 0;
        for (int num : nums) {
            if (num > f) {
                s = f;
                f = num;
            }
            else if (num > s && num != f) {
                s = num;
            }
        }
        return (s - 1) * (f - 1);
    }
}
