package main.Coding.Algorithms.Normal.MaximumU_1710;

import java.util.Arrays;

public class TEST {
    public static void main(String[] args) {

    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // remember the way to arrange sort
        Arrays.sort(boxTypes, (int[] a, int[] b) -> a[1] - b[1]);
        int ans = 0;
        for (int i = boxTypes.length - 1; i >= 0; i--) {
            int curType = boxTypes[i][0];
            int curVal = boxTypes[i][1];
            while (curType > 0 && truckSize > 0) {
                curType--;
                truckSize --;
                ans += curVal;
            }
        }
        return ans;
    }
}
