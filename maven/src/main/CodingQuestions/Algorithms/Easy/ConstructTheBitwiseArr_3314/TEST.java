package main.CodingQuestions.Algorithms.Easy.ConstructTheBitwiseArr_3314;

import java.util.List;

public class TEST {
    public static void main(String[] args) {

    }
    
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] result = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            int original = nums.get(i);
            int candidate = -1;
            for (int j = 1; j < original; j++) {
                if ((j | (j + 1)) == original) {
                    candidate = j;
                    break;
                }
            }
            result[i] = candidate;
        }
        return result;
    }
}
