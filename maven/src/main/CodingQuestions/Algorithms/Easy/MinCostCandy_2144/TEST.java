package main.CodingQuestions.Algorithms.Easy.MinCostCandy_2144;

import java.util.Arrays;

public class TEST {
    public static void main(String[] args) {

    }
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int res = 0;
        int n = cost.length;
        for (int i = n - 1; i >= 0; i--) {
            if ((n - 1 - i) % 3 != 2) {
                res += cost[i];
            }
        }
        return res;
    }
}
