package main.Coding.Algorithms.Medium.MaAfterDecNSort_1846;

import java.util.Arrays;

public class TEST {
    public static void main(String[] args) {

    }
    
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int ans = 1;
        arr[0] = 1;
        for (int i = 1; i < arr.length;i++) {
            if (arr[i] - arr[i - 1] >= 1) {
                arr[i] = arr[i-1] + 1;
            }
            ans = Math.max(ans, arr[i]);
        }
        return ans;
    }
}
