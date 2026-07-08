package main.Coding.Algorithms.Medium.ConcatenMultiple_3756;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.sumAndMultiply("9876543210", new int [][] {{0,9}});
    }
    public int[] sumAndMultiply(String s, int[][] queries) {
        int mod = 1000000007;
        int len = queries.length;
        int [] ans = new int [len];
        for (int i = 0; i < len; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            StringBuilder sb = new StringBuilder();
            long sum = 0;
            long con = 0;
            while (l <= r) {
                if (s.charAt(l) != '0') {
                    sb.append(s.charAt(l));
                    sum += Integer.parseInt(s.charAt(l)+"");
                }
                l++;
            }
            if (sb.length() == 0) {
                ans[i] = 0;
            } else {
                sum %= mod;
                con = Long.valueOf(sb.toString()) % mod;
                ans[i] = (int)((sum *con) % mod);
            }
        }
        return ans;
    }
}
