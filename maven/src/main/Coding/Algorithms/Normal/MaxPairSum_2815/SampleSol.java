package main.Coding.Algorithms.Normal.MaxPairSum_2815;

public class SampleSol {
    public static void main(String[] args) {

    }
    public int maxSum(int[] nums) {
        int[] maxNum = new int[10];
        int ans = -1;

        for (int num : nums) {
            int largestDigit = getLargestDigit(num);

            if (maxNum[largestDigit] != 0) {
                ans = Math.max(ans, num + maxNum[largestDigit]);
            }

            maxNum[largestDigit] = Math.max(maxNum[largestDigit], num);
        }

        return ans;
    }

    private int getLargestDigit(int num) {
        int maxDigit = 0;

        while (num > 0) {
            maxDigit = Math.max(maxDigit, num % 10);
            num /= 10;
        }

        return maxDigit;
    }
}
