package main.Coding.Algorithms.Normal.ArrayTransformation_1243;

import java.util.ArrayList;
import java.util.List;

public class SampleSolution2 {
    public static void main(String[] args) {

    }

    public List<Integer> transformArray(int[] arr) {
        boolean changed = true;

        while (changed) {
            changed = false;
            int p = arr[0], t = 0;
            for (int i = 1; i < arr.length - 1; i++) {
                t = arr[i];
                if (arr[i] > p && arr[i] > arr[i + 1]) {
                    arr[i]--;
                    changed = true;
                } else if (arr[i] < p && arr[i] < arr[i + 1]) {
                    arr[i]++;
                    changed = true;
                }
                p = t;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int num : arr) {
            res.add(num);
        }
        return res;
    }
}
