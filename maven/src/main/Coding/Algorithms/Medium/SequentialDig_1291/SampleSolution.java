package main.Coding.Algorithms.Medium.SequentialDig_1291;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SampleSolution {
    public static void main(String[] args) {
        SampleSolution solution = new SampleSolution();
        solution.sequentialDigits(100, 300);
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> a = new ArrayList<>();
        for (int i = 1; i <= 9; ++i) {
            int num = i;
            int nextDigit = i + 1;
            while (num <= high && nextDigit <= 9) {
                num = num * 10 + nextDigit;
                if (low <= num && num <= high) {
                    a.add(num);
                }
                ++nextDigit;
            }
        }

       Collections.sort(a);
        return a;
    }
}
