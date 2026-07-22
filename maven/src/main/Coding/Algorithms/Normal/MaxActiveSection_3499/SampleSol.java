package main.Coding.Algorithms.Normal.MaxActiveSection_3499;

import java.util.ArrayList;
import java.util.List;

public class SampleSol {

    public static void main(String[] args) {
        SampleSol test = new SampleSol();
        test.maxActiveSectionsAfterTrade("0100");
    }

    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int cnt1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') cnt1++;
        }

        List<Integer> zeroBlocks = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int start = i;
            while (i < n && s.charAt(i) == s.charAt(start)) {
                i++;
            }
            if (s.charAt(start) == '0') {
                zeroBlocks.add(i - start);
            }
        }

        int m = zeroBlocks.size();
        if (m < 2) {
            return cnt1;
        }
        int bestGain = 0;
        for (int j = 0; j < m - 1; j++) {
            bestGain = Math.max(bestGain, zeroBlocks.get(j) + zeroBlocks.get(j + 1)
            );
        }

        return cnt1 + bestGain;
    }
}
