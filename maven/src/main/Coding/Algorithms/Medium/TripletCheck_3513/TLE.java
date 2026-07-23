package main.Coding.Algorithms.Medium.TripletCheck_3513;

import java.util.HashSet;

public class TLE {
    public static void main(String[] args) {

    }
    public int uniqueXorTriplets(int[] nums) {
        int len = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    hs.add(nums[i] ^ nums[j] ^ nums[k]);
                }
            }
        }
        return hs.size();
    }
}
