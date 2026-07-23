package main.Coding.Algorithms.Medium.TripletCheck_3513;

import java.util.HashSet;

public class TEST {
    public static void main(String[] args) {

    }
    public int uniqueXorTriplets(int[] nums) {
        int len = nums.length;
        HashSet<Integer> pairXors = new HashSet<>();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                pairXors.add(nums[i] ^ nums[j]);
            }
        }

        HashSet<Integer> result = new HashSet<>();
        for (int pairXor : pairXors) {
            for (int num : nums) {
                result.add(pairXor ^ num);
            }
        }

        return result.size();
    }
}
