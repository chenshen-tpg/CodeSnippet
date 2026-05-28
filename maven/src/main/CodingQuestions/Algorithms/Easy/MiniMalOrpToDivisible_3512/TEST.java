package main.CodingQuestions.Algorithms.Easy.MiniMalOrpToDivisible_3512;

public class TEST {
    public static void main(String[] args) {

    }
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum % k;
    }
}
