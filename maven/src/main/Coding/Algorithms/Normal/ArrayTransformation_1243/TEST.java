package main.Coding.Algorithms.Normal.ArrayTransformation_1243;

import java.util.Arrays;
import java.util.List;

public class TEST {
    public static void main(String[] args) {

    }
    public List<Integer> transformArray(int[] arr) {
        while (!check(arr)) {
            int[] copy = arr.clone(); // snapshot before this pass
            for (int i = 1; i < arr.length - 1; i++) {
                if (copy[i] > copy[i-1] && copy[i] > copy[i+1]){
                    arr[i]--;
                }
                if (copy[i] < copy[i-1] && copy[i] < copy[i+1]) {
                    arr[i]++;
                }
            }
        }
        return Arrays.stream(arr).boxed().toList();
    }
    public boolean check (int [] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                return false;
            }
            if (arr[i] < arr[i-1] && arr[i] < arr[i+1]) {
                return false;
            }
        }
        return true;
    }
}
