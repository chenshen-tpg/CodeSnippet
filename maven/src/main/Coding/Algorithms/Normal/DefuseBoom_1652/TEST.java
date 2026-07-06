package main.Coding.Algorithms.Normal.DefuseBoom_1652;

import java.util.Arrays;

public class TEST {

    public static void main(String[] args) {
        TEST solution = new TEST();
        solution.decrypt(new int [] {2,4,9,3}, - 2);
    }

    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        if (k > 0) {
            int [] forward = new int [len];
            for (int i = 0; i < len; i++) {
                int cur = 0;
                for (int j = 1; j <= k; j++) {
                    cur += code[(i + j) % len];
                }
                forward[i] = cur;
            }
            return forward;
        } else if (k == 0) {
            return new int[len];
        } else {
            int[] backward = new int[len];
            int steps = -k;
            for (int i = 0; i < len; i++) {
                int cur = 0;
                for (int s = 1; s <= steps; s++) {
                    cur += code[(i - s + len) % len];
                }
                backward[i] = cur;
            }
            return backward;
        }
    }
}
