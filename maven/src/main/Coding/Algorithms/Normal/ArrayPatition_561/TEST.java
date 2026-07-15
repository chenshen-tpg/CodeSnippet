package main.Coding.Algorithms.Normal.ArrayPatition_561;

import java.util.Arrays;

public class TEST {
    public static void main(String[] args) {

    }
    public int arrayPairSum(int[] nums) {
        int n=nums.length,res=0;
        Arrays.sort(nums);
        for(int i=0;i<n;i+=2)
        {
            res+=nums[i];
        }
        return res;
    }
}
