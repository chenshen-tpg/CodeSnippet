package main.CodingQuestions.Algorithms.Easy.SetMismatch_645;

public class SampleAns {
    public static void main(String[] args) {
        
    }
    public int[] findErrorNums(int[] nums) {
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
}
