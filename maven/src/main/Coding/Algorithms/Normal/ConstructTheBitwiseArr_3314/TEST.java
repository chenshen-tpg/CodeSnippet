package main.Coding.Algorithms.Normal.ConstructTheBitwiseArr_3314;

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
    public int[] Optimization(List<Integer> nums) {
        int len = nums.size();
        int [] res = new int [len];
        for (int i = 0; i < len; i++) {
            int temp = nums.get(i);
            res[i] = -1;
            for (int j = 1; j < temp; j++) {
                if ((j | (j+1)) == temp){
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }
}
