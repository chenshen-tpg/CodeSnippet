package main.Coding.Algorithms.Normal.FindMissingEle_3731;

import java.util.ArrayList;
import java.util.List;

public class TEST {
    public static void main(String[] args) {

    }

    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> al = new ArrayList();
        int max = 0;
        int min = 101;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int [] memo = new int [max + 1];
        for (int i = 0; i < nums.length; i++) {
            memo[nums[i]]++;
        }
        for (int i = min; i < memo.length; i++) {
            if (memo[i] == 0) {
                al.add(i);
            }
        }
        return al;
    }
}
