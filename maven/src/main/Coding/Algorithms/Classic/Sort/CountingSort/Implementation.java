package main.Coding.Algorithms.Classic.Sort.CountingSort;

import java.util.HashMap;

public class Implementation {

    public static void main(String[] args) {

    }

    public int[] sortArray(int[] nums) {
        countingSort(nums);
        return nums;
    }

    private void countingSort(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int min = arr[0], max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        int index = 0;
        for (int i = min; i <= max; i++) {
            while (hm.getOrDefault(i, 0) > 0) {
                arr[index++] = i;
                hm.put(i, hm.get(i) - 1);
            }
        }
    }
}
