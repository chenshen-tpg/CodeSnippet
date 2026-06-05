package main.Coding.Algorithms.Normal.MinimalChangesToBS_1758;

public class TRY {
    public static void main(String[] args) {

    }
    public int minOperations(String s) {
        int ans = 0;
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        if (s.charAt(0) == '0') {
            for (int i = 0; i < len; i++) {
                if (i % 2 == 0) {
                    sb.append("0");
                } else {
                    sb.append("1");
                }
            }
        } else {
            for (int i = 0; i < len; i++) {
                if (i % 2 == 0) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != sb.toString().charAt(i)) {
                ans++;
            }
        }
        return ans;
    }

    public int minOperationsAISolution(String s) {
        int n = s.length();
        int count1 = 0, count2 = 0;
        for (int i = 0; i < n; i++) {
            char expected1 = (i % 2 == 0) ? '0' : '1';
            char expected2 = (i % 2 == 0) ? '1' : '0';
            if (s.charAt(i) != expected1) count1++;
            if (s.charAt(i) != expected2) count2++;
        }
        return Math.min(count1, count2);
    }
}
