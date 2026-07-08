package main.Coding.Algorithms.Medium.ConcatenMultiple_3756;

public class SampleSolution {


    public static void main(String[] args) {
        SampleSolution test = new SampleSolution();
        test.sumAndMultiply("9876543210", new int [][] {{0,9}});
    }

    public int[] sumAndMultiply(String s, int[][] queries) {
        int mod = 1000000007;
        int n = s.length();
        long[] prefixSum = new long[n + 1];
        long[] prefixCon = new long[n + 1];
        prefixSum[0] = 0;
        prefixCon[0] = 0;
        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            if (digit != 0) {
                prefixSum[i + 1] = (prefixSum[i] + digit) % mod;
                prefixCon[i + 1] = (prefixCon[i] * 10 + digit) % mod;
            } else {
                prefixSum[i + 1] = prefixSum[i];
                prefixCon[i + 1] = prefixCon[i];
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            long sum = prefixSum[r + 1] - prefixSum[l];
            long con = prefixCon[r + 1];

            if (sum == 0) {
                ans[i] = 0;
            } else {
                ans[i] = (int)((sum * con) % mod);
            }
        }
        return ans;
    }
}
