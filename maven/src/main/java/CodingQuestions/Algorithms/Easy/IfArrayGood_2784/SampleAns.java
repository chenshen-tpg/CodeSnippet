package CodingQuestions.Algorithms.Easy.IfArrayGood_2784;

public class SampleAns {
    public static void main(String[] args) {

    }

    public boolean isGood(int[] nums) {
        int[] memo = new int[201];
        int max = 0;
        for (int num : nums) {
            memo[num]++;
            max = Math.max(max, num);
        }
        if (nums.length != max + 1) return false;

        for (int i = 1; i < max; i++) {
            if (memo[i] != 1) return false;
        }
        return memo[max] == 2;
    }
}
