package main.Coding.Algorithms.Medium.FindtheLengthOfLongestPrefix_3043;

import java.util.HashSet;

public class SampleAnswer {
    public static void main(String[] args) {

    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> hs = new HashSet();
        for (int arr : arr1) {
            while (!hs.contains(arr) && arr > 0) {
                hs.add(arr);
                arr /= 10;
            }

        }
        int ans = 0;
        for (int arr : arr2) {
            while (!hs.contains(arr) && arr > 0) {
                arr /= 10;
            }
            int digits = 0, temp = arr;
            while (temp > 0) {
                digits++;
                temp /= 10;
            }
            ans = Math.max(ans, digits);
        }
        return ans;
    }
}
