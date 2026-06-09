package main.Coding.Algorithms.Medium.MaxtotalVal_3689;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.maxTotalValue(new int [] {4,2,5,1}, 3);
    }


    public long maxTotalValue(int[] nums, int k) {
        int m1 = Integer.MAX_VALUE;
        int m2 = Integer.MIN_VALUE;
        for (int x : nums) {
            m1 = Math.min(m1, x);
            m2 = Math.max(m2, x);
        }
        return (long) (m2 - m1) * k;
    }
}
