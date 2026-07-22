package main.Coding.Algorithms.Normal.LongestSubWithSum_2389;

import java.util.Arrays;

public class SampleSol1 {

    public static void main(String[] args) {

    }


    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = upperBound(prefix, queries[i]); // count of values <= query
        }
        return ans;
    }

    private int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length; // [left, right)
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
