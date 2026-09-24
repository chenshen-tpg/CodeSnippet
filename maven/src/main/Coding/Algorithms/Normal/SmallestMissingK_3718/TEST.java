package main.Coding.Algorithms.Normal.SmallestMissingK_3718;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.missingMultiple(new int [] {8,2,3,4,6}, 2);
    }

    public int missingMultiple(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }
        int ans = k;
        while (seen.contains(ans)) {
            ans += k;
        }
        return ans;
    }
}
