package main.Coding.Algorithms.Medium.TotalWaveiness_3751;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.totalWaviness(120,130);
    }

    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for (int i = num1; i <= num2; i++) {
            String tem = String.valueOf(i);
            if (tem.length() < 3) continue;
            for (int j = 1; j < tem.length() - 1; j++) {
                int prev = Integer.valueOf(tem.charAt(j - 1));
                int next = Integer.valueOf(tem.charAt(j + 1));
                int cur = Integer.valueOf(tem.charAt(j));
                if (cur > prev && cur > next) ans++;
                if (cur < prev && cur < next) ans++;
            }
        }
        return ans;
    }
}
