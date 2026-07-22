package main.Coding.Algorithms.Normal.LongestSubWithSum_2389;

import java.util.Arrays;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.answerQueries(new int [] {4,5,2,1}, new int [] {3,10,21});
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        int [] ans = new int [queries.length];
        Arrays.sort(nums);
        int i = 0;
        for (int query : queries) {
            int count = 0;
            int len = 0;
            for (int j = 0; j < nums.length; j++) {
                count += nums[j];
                if (count > query) {
                    break;
                }
                len++;
            }
            ans[i] = len;
            i++;
        }
        return ans;
    }

}
