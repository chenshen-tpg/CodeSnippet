package main.Coding.Algorithms.Medium.SequentialDig_1291;

import java.util.ArrayList;
import java.util.List;

public class SampleSolution2 {
    public static void main(String[] args) {
        SampleSolution2 solution = new SampleSolution2();
        solution.sequentialDigits(100, 300);
    }

    public List<Integer> sequentialDigits(int low, int high) {
        String str = "123456789";
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; i + j <= 9; j++) {
                String sub = str.substring(j, i + j);
                int val = Integer.valueOf(sub);
                if (val >= low && val <= high) {
                    list.add(val);
                }
            }
        }
        return list;
    }
}
