package main.Coding.Algorithms.Normal.MaxPairSum_2815;

import main.Coding.Lib.Pair;

import java.util.*;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.maxSum(new int [] {51,71,17,24,42});
    }
    public int maxSum(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int ans = -1;

        for (int num : nums) {
            int maxDigit = getMaxDigit(num);

            map.putIfAbsent(maxDigit, new int[]{-1, -1});
            int[] best = map.get(maxDigit);

            if (num > best[0]) {
                best[1] = best[0];
                best[0] = num;
            } else if (num > best[1]) {
                best[1] = num;
            }

            if (best[0] != -1 && best[1] != -1) {
                ans = Math.max(ans, best[0] + best[1]);
            }
        }

        return ans;
    }

    private int getMaxDigit(int num) {
        int maxDigit = 0;
        while (num > 0) {
            maxDigit = Math.max(maxDigit, num % 10);
            num /= 10;
        }
        return maxDigit;
    }
}
