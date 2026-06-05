package main.Coding.Algorithms.Normal.SetMismatch_645;

public class SampleAns {
    public static void main(String[] args) {

    }
    public int[] findErrorNumsA(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n+1];
        for(int num: nums){
            freq[num]++;
        }
        int duplicate = 0;
        int missing = 0;
        for(int i = 1; i <= n; i++){
            if(freq[i] == 0) missing = i;
            else if(freq[i] > 1) duplicate = i;
        }
        return new int[]{duplicate, missing};
    }
    public int[] findErrorNumsB(int[] nums) {
        int len = nums.length;
        int [] memo = new int [len + 1];
        for (int i = 0; i < len; i++) {
            memo[nums[i]]++;
        }
        int missing = 0;
        int duplicate = 0;
        for (int i = 1; i <= len; i++) {
            if (memo[i] > 1) duplicate = i;
            if (memo[i] == 0) missing = i;
        }
        return new int [] {duplicate, missing};
    }
}
