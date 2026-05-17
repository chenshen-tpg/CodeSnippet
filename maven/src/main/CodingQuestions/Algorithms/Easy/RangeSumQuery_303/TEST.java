package main.CodingQuestions.Algorithms.Easy.RangeSumQuery_303;

public class TEST {

    int[] prefix;

    public TEST(int[] nums) {
        prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i += 1)
            prefix[i] = prefix[i - 1] + nums[i];

    }

    public static void main(String[] args) {
        TEST test = new TEST(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(test.sumRange(2, 5));
    }

    public int sumRange(int left, int right) {
        if (left == 0) return prefix[right];
        return prefix[right] - prefix[left - 1];

    }
}
