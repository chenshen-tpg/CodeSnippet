package main.Coding.Algorithms.Normal.DefuseBoom_1652;

import java.util.Arrays;

public class SampleAns {
    public static void main(String[] args) {

    }
    public int[] decrypt(int[] code, int k) {

        int[] ans = new int[code.length];
        if (k == 0) {
            Arrays.fill(ans, 0);
        } else if (k > 0) {
            for (int i = 0; i < code.length; i++) {
                int currsum = 0;
                int tempK = k;
                int j = i + 1;

                while (tempK != 0) {
                    if (j == code.length)
                        j = 0;
                    currsum += code[j];
                    j++;
                    tempK--;
                }
                ans[i] = currsum;
            }
        } else if (k < 0) {
            for (int i = 0; i < code.length; i++) {
                int currsum = 0;
                int tempK = -k;      // make it positive
                int j = i - 1;
                while (tempK-- > 0) {
                    if (j < 0)
                        j = code.length - 1;
                    currsum += code[j];
                    j--;
                }

                ans[i] = currsum;
            }
        }
        return ans;
    }
}
