package CodingQuestions.Algorithms.Easy.IfArrayGood_2784;

import java.util.Arrays;

public class MySolution {
    /***
     *
     *
     You are given an integer array nums. We consider an array good if it is a permutation of an array base[n].
     base[n] = [1, 2, ..., n - 1, n, n] (in other words, it is an array of length n + 1 which contains 1 to n - 1 exactly once, plus two occurrences of n).
     For example, base[1] = [1, 1] and base[3] = [1, 2, 3, 3].
     Return true if the given array is good, otherwise return false.
     Note: A permutation of integers represents an arrangement of these numbers.
     */
    public static void main(String[] args) {

    }
    public boolean isGood(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if (n == 1 || nums[0] != 1) {
            return false;
        }
        for (int i = 1; i <= n - 2; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                return false;
            }
        }
        return nums[n - 1] == nums[n - 2];

    }
}
