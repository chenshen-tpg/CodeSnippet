package main.CodingQuestions.Algorithms.Easy.MinimalE_3300;

public class TEST {
    public static void main(String[] args) {

    }

    public int minElement(int[] nums) {
        int sum =Integer.MAX_VALUE;
        for (int num : nums) {
            int cur = 0;
            while (num > 0) {
                int temp = num;
                cur += temp % 10;
                num /= 10;
            }
            sum = Math.min(sum, cur);
        }
        return sum;
    }
}
