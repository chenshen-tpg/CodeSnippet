package main.Coding.Algorithms.Normal.GoodPair_1512;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.numIdenticalPairs(new int [] {1,1,1,1});
    }
    public int numIdenticalPairs(int[] nums) {
        int [] memo = new int [101];
        int ans = 0;
        for (int num : nums) {
            ans += memo[num];
            memo[num]++;
        }
        return ans;
    }
}
