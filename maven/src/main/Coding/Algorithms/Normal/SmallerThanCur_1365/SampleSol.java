package main.Coding.Algorithms.Normal.SmallerThanCur_1365;

public class SampleSol {
    public static void main(String[] args) {
        SampleSol test = new SampleSol();
        test.smallerNumbersThanCurrent(new int [] {8,1,2,2,3});

    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int [] memo = new int [102];
        int [] ans = new int [len];
        for (int num : nums) {
            memo[num]++;
        }
        int cur = 0;
        for (int i = 0; i < 102; i++) {
            int curFre = memo[i];
            memo[i] = cur;
            cur += curFre;
        }
        for (int i = 0; i < len; i++) {
            ans[i] = memo[nums[i]];
        }
        return ans;
    }
}
