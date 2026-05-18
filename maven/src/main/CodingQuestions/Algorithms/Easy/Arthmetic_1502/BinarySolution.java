package main.CodingQuestions.Algorithms.Easy.Arthmetic_1502;

import java.util.Arrays;

public class BinarySolution {
    public static void main(String[] args) {

    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        int size = arr.length;
        if (size == 2) return true;
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        int n = 1;
        while (n - 1 < size / 2) {
            int diffA = arr[n + 1] - arr[n];
            if (diffA != diff) return false;
            int diffB = arr[size - n] - arr[size - n - 1];
            if (diffB != diff) return false;
            n++;
        }
        return true;
    }
}
