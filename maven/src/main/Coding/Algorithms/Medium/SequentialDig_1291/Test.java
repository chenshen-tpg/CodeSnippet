package main.Coding.Algorithms.Medium.SequentialDig_1291;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Test solution = new Test();
        solution.sequentialDigits(100, 300);
    }

    public List<Integer> sequentialDigits(int low, int high) {
        String sample = "123456789";
        List<Integer> ans = new ArrayList();
        int l = getLen(low);
        int r = getLen(high);
        for (int i = l; i < r + 1; i++) {
            for (int j = 0; j < 10 - i; j++) {
                int num = Integer.parseInt(sample.substring(j, j + i));
                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }
        return ans;
    }

    public int getLen (int i) {
        int j = 0;
        while (i > 0) {
            i /= 10;
            j++;
        }
        return j;
    }
}
