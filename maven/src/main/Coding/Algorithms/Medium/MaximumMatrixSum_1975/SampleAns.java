package main.Coding.Algorithms.Medium.MaximumMatrixSum_1975;

public class SampleAns {
    public static void main(String[] args) {

    }
    public long maxMatrixSum(int[][] matrix) {
        long ans = 0;
        int min = Integer.MAX_VALUE;
        int neg = 0;
        for (int[] row : matrix) {
            for (int val : row) {
                ans += Math.abs(val);
                if (val < 0) {
                    neg++;
                }
                min = Math.min(min, Math.abs(val));
            }
        }
        if (neg % 2 != 0) {
            ans -= 2 * min;
        }
        return ans;
    }
}
