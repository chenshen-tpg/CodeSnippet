package main.CodingQuestions.Algorithms.Easy.Arthmetic_1502;

import java.util.Arrays;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.canMakeArithmeticProgression(new int [] {3,5,1});
    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        Boolean forwardResult = true;
        Boolean backwardResult = true;
        Arrays.sort(arr);
        if (arr.length == 2) return true;
        int forward = arr[1] - arr[0];
        int backward = arr[0] - arr[1];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != forward) forwardResult = false;
        }
        for (int i = arr.length - 1; i >= 1; i--) {
            if (arr[i - 1] - arr[i] != forward) backwardResult = false;
        }
        return forwardResult || backwardResult;
    }
    public boolean forwardOnly(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        if (len == 2) return true;
        int forward = arr[1] - arr[0];
        for (int i = 1; i < len; i++) {
            if (arr[i] - arr[i - 1] != forward) {
                return false;
            }
        }
        return true;
    }
}
