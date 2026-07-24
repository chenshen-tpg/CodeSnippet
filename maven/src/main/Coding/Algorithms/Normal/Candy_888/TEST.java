package main.Coding.Algorithms.Normal.Candy_888;

import java.util.HashSet;

public class TEST {
    public static void main(String[] args) {

    }

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;
        for (int a : aliceSizes) sumA += a;
        HashSet<Integer> set = new HashSet<>();
        for (int b : bobSizes) {
            sumB += b;
            set.add(b);
        }

        int diff = (sumA - sumB) / 2;

        for (int a : aliceSizes) {
            int b = a - diff;
            if (set.contains(b)) {
                return new int[]{a, b};
            }
        }

        return new int[0];
    }
}
