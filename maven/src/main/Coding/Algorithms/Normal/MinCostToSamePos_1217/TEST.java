package main.Coding.Algorithms.Normal.MinCostToSamePos_1217;

import java.util.HashSet;

public class TEST {

    public static void main(String[] args) {

    }
    public int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;
        for (int p : position) {
            if ((p & 1) == 0) even++;
            else odd++;
        }
        return Math.min(odd, even);
    }
}
